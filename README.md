# Software engineering project

Made by group 28, composed of: Alessio, Emanuele, Mattia, Giampiero. <br>
This project is the final test for the Software Engineering course of Computer Science Engineering at the Polytechnic of Milan.
---
![Title](https://user-images.githubusercontent.com/126590912/237023835-855ab60b-0444-4b1a-87fa-f940cd771a04.png)

## Project Specification
The project involves creating a Java version of the board game MyShelfie, developed by Cranio Games.<br><br>
Our project focuses on implementing a distributed system consisting of a server with multiple clients capable
of handling multiple games. <br><br>
We have adopted the Model-View-Controller (MVC) pattern for code organization. <br><br>The system provides both a command-line interface (CLI) and a graphical user interface (GUI) for user interaction.
* [Download detailed requirements here!](https://github.com/AlessioTommasi-polimi/ing-sw-2023-paganini-tommasi-russo-porfiri/blob/main/documentation/requirements.pdf)
* [Download detailed rolebook here!](https://github.com/AlessioTommasi-polimi/ing-sw-2023-paganini-tommasi-russo-porfiri/blob/main/documentation/MyShelfie_Rulebook_ITA.pdf)
---
## Implemented functionalities

### Game specific

| Objective        |  |
|------------------|------------|
| Simplified rules | ✅          |
| Complete rules   | ✅          |

### Game agnostic

#### Server
| Objective                                                      |  |
|----------------------------------------------------------------|------------|
| Rules implementation                                           | ✅          |
| Single instantiation (with multiple games management)          | ✅          |
| Client-server connection through RMI and socket implementation | ✅          |

#### Client
| Objective                                  |  |
|--------------------------------------------|------------|
| Multiple instantiation on the same machine | ✅          |
| GUI implemented through JavaFX             | ✅          |
| Client-socket or client-RMI jar            | ✅          |

### Advanced functionalities
| Objective                                     |  |
|-----------------------------------------------|------------|
| Server managing multiple games simultaneously | ✅          |
| In-game chat                                  | ✅          |

---
## Technology stack
* javafx-controls:20
* javafx-fxml:20
* controlsfx:11.1.2
* gson:2.10.1
* junit:4.13.2
---
## Starting the game

### Cloning and running
To clone and run this application, you'll need [Git](https://git-scm.com) and Java installed on your computer.
From your command line:

```bash
# Clone this repository
$ git clone https://github.com/AlessioTommasi-polimi/ing-sw-2023-paganini-tommasi-russo-porfiri.git

# Go into the repository
$ cd ./ing-sw-2023-paganini-tommasi-russo-porfiri/src/main/java/org/example

# Start Server
$ cd Server
$ java -jar softeng-gc28.java

# Run the Client  Socket
$ cd ../ClientSocket
$ java -jar softeng-gc28.java

# or Run the Client RMI (or both)
$ cd ../ClientRMI
$ java -jar softeng-gc28.java

```

> **Note**
> This may not work if you haven't already compiled the project.
---
## Gameplay
### Before the game
On the login page, the user is prompted to enter their player username and specify the number of players who will participate in the game.

If a game with the specified number of players does not exist, a new room will be created for them.

If a game with the specified number of players already exists, the player will join that room and wait for additional
users until the room reaches its maximum player capacity, which was determined during the room's creation.
### After the game
When the game ends, the player will have the opportunity to take a look at the game's rankings and the shelves, after which they can close it and re-run the application to play another match. 
### Game interruptions

The game may not have a winner if a player disconnects during the game, as it will result in all players being
disconnected, leaving the game without a winner.

---
## Contributors
Made with ❤️ by GC28, scaglione Cugola.
> **Contact Information** <br>
> mail: [alessio.tommasi@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@AlessioTommasi-polimi](https://github.com/AlessioTommasi-polimi) <br>
> mail: [giampiero.porfiri@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@Giampiero-Porfiri](https://github.com/Giampiero-Porfiri) <br>
> mail: [emanuele.russo@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@EmanueleRuss0](https://github.com/EmanueleRuss0) <br>
> mail: [mattia.paganini@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@MattiaPaganini](https://github.com/MattiaPaganini) <br>
