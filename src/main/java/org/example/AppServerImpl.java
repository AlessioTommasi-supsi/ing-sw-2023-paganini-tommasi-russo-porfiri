package org.example;
import org.example.distributed.*;
import org.example.distributed.socket.middleware.*;
import org.example.view.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppServerImpl extends UnicastRemoteObject implements AppServer
{

    private static AppServerImpl instance;

    private static ServerImpl serverImpl=null;

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    protected AppServerImpl() throws RemoteException {
    }

    public static AppServerImpl getInstance() throws RemoteException {
        if (instance == null) {
            instance = new AppServerImpl();
        }
        return instance;
    }

    public static void main(String[] args) {

        Thread rmiThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("starting RMI");
                    startRMI();
                } catch (RemoteException e) {
                    System.err.println("Cannot start RMI. This protocol will be disabled.");
                }
            }
        };

        System.out.println("starting connection with RMI");
        rmiThread.start();

        Thread socketThread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("creating SOCKET");
                    startSocket();
                } catch (RemoteException e) {
                    System.err.println("Cannot start socket. This protocol will be disabled.");
                }
            }
        };

        socketThread.start();

        try {
            rmiThread.join();
            socketThread.join();
        } catch (InterruptedException e) {
            System.err.println("No connection protocol available. Exiting...");
        }
    }

    private static void startRMI() throws RemoteException {
        AppServerImpl server = getInstance();
        try {
            java.rmi.registry.LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (RemoteException e) {
            System.err.println("error starting rmi");
            e.printStackTrace();
        }
        Registry registry = LocateRegistry.getRegistry();
        registry.rebind("server", server);
    }

    public static void startSocket() throws RemoteException {
        AppServerImpl instance = getInstance();
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {
                Socket socket = serverSocket.accept();
                instance.executorService.submit(() -> {
                    try {
                        ClientSkeleton clientSkeleton = new ClientSkeleton(socket);
                        if(serverImpl == null)
                            serverImpl =new ServerImpl();
                        else
                            serverImpl =new ServerImpl(serverImpl.model);


                        serverImpl.register(clientSkeleton);
                        while (true) {
                            clientSkeleton.receive(serverImpl);
                        }
                    } catch (RemoteException e) {
                        System.err.println("Cannot receive from client. Closing this connection...");
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            System.err.println("Cannot close socket");
                        }
                    }
                });
            }
        } catch (IOException e) {
            throw new RemoteException("Cannot start socket server", e);
        }
    }

    @Override
    public Server connect() throws RemoteException {
        if(this.serverImpl == null)
            this.serverImpl =new ServerImpl();
        else
            this.serverImpl =new ServerImpl(this.serverImpl.model);
        return this.serverImpl;
    }
}
