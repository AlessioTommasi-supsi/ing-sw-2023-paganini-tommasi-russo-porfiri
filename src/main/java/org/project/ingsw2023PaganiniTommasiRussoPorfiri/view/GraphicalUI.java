package org.project.ingsw2023PaganiniTommasiRussoPorfiri.view;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.Choice;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.ChoiceMyShelfie;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.Player;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.TurnView;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.Observable;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.SwingUI.LoginGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GraphicalUI extends Observable<ChoiceMyShelfie> implements Runnable{
    private enum State {
        WAITING_FOR_PLAYER,
        WAITING_FOR_OUTCOME
    }



    private State state = State.WAITING_FOR_PLAYER;
    private final Object lock = new Object();



    private final ActionListener playActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                Choice c = new Choice(ChoiceMyShelfie.JOIN_GAME, new Player("test"),2);
                setState(State.WAITING_FOR_OUTCOME);
                setChanged();
                notifyObservers(c);

        }
    };
    private final LoginGUI frame = new LoginGUI();

    private State getState() {
        synchronized (lock) {
            return state;
        }
    }

    private void setState(State state) {
        synchronized (lock) {
            this.state = state;
            SwingUtilities.invokeLater(() -> {
                frame.joinGameButton.setEnabled(state == State.WAITING_FOR_PLAYER);
            });
            lock.notifyAll();
        }
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(() ->
        {
            frame.setVisible(true);
            setState(State.WAITING_FOR_PLAYER);
        });
    }

    public void update(TurnView model, Choice arg) {
        frame.playerNumberField.setText("server respond! :)");
        this.setState(State.WAITING_FOR_PLAYER);
    }

    private void showOutcome(TurnView model) {

        /* Output Outcome */
        SwingUtilities.invokeLater(() -> {
            frame.titleLabel.setText("You win! :)");
        });
    }

    private void showChoices(TurnView model) {
        /* Show CPU's choice */

        SwingUtilities.invokeLater(() -> {
            frame.joinGameButton.setIcon(new ImageIcon("src/main/resources/GraphicResources/boards/bookshelf.png"));
        });
    }
}
