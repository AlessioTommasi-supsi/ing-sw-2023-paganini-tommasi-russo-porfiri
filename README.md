# Software 

Made by group 28, composed of: Alessio Tommasi, Emanuele Russo, Mattia Paganini, Giampiero Porfiri. <br>
This project is the final test for the Software Engineering course of Computer Science Engineering at the Polytechnic of Milan.
---
![Title](https://user-images.githubusercontent.com/126590912/237023835-855ab60b-0444-4b1a-87fa-f940cd771a04.png)

---
## Project Specification
The project involves creating a Java version of the board game MyShelfie, developed by Cranio Games.<br><br>
Our project focuses on implementing a distributed system consisting of a server with multiple clients capable
of handling multiple games. <br><br>
We have adopted the Model-View-Controller (MVC) pattern for code organization. <br><br>The system provides both a command-line interface (CLI) and a graphical user interface (GUI) for user interaction.
* [Download detailed requirements here!](https://github.com/AlessioTommasi-polimi/ing-sw-2023-paganini-tommasi-russo-porfiri/blob/main/documentation/requirements.pdf)
* [Download detailed rulebook here!](https://github.com/AlessioTommasi-polimi/ing-sw-2023-paganini-tommasi-russo-porfiri/blob/main/documentation/MyShelfie_Rulebook_ITA.pdf)

---

# Summary

- [Sommario](#Summary)
- [UML & Documentation](#uml-and-documentation)
- - [Sequence Diagram](#Sequence-Diagram)
- [Implemented functionalities](#implemented-functionalities)
- - [Game specific](#game-specific)
- - [Game agnostic](#game-agnostic)
- - - [Server](#server)
- - - [Client](#client)
- - [Advanced functionalities](#advanced-functionalities)
- [Technology stack](#technology-stack)
- [Required dependencies](#required-dependencies)
- [Setup](#setup)
- [Compile and packaging](#compile-and-packaging)
- [GamePlay](#gameplay)
- -[Graphical User Interface](#graphical-interface-guide)
- -[Examples](#examples)
- [Implemented Functionalities](#implemented-functionalities)
- [Contributors](#contributors)

## UML and Documentation
<br>

![Connection diagram 1.png](deliveries%2Fdocumentation%2Fuml%2FDetailed%2FConnection%20diagram%201.png)

---
### Sequence Diagram:
![SequenceDiagram.jpg](deliveries%2Fdocumentation%2Fuml%2FSequenceDiagram.jpg)
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
* maven-compiler-plugin
* javafx-maven-plugin
* maven-shade-plugin
* controlsfx:11.1.2
* gson:2.10.1
* junit:4.13.2
---

## Required dependencies
To clone and run this application, you'll need [Git](https://git-scm.com) and Java installed on your computer.
From your command line:

```bash
# Install Maven for compiling (only for mac users and linux users)
$ brew install git
$ brew install maven
```

### Windows users
[Git guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
<br>[Maven guide](https://maven.apache.org/)
<br>Maven shade plugin: [Maven plugin](https://maven.apache.org/plugins/maven-shade-plugin/)


### All Operative Systems
install open jdk 20.0.1 here: [OpenJDK](https://www.oracle.com/java/technologies/downloads/)

## Setup
```bash
# Clone this repository
$ git clone https://github.com/AlessioTommasi-polimi/ing-sw-2023-paganini-tommasi-russo-porfiri.git
# Go into the repository
$ cd ./ing-sw-2023-paganini-tommasi-russo-porfiri
```

## Compile and packaging
The jars were made with the help of Maven Shade Plugin.
Below are the precompiled jars.
To compile the jars independently, position yourself in the root of the project and launch the command:
```bash
$ mvn clean package
```
I jar compilati verranno posizionati all'interno della cartella ```target/``` con i nomi:<br><br>
```ing-sw-2023-paganini-tommasi-russo-porfiri-server.jar```, <br>
```ing-sw-2023-paganini-tommasi-russo-porfiri-clientRMI.jar e ```<br>
```ing-sw-2023-paganini-tommasi-russo-porfiri-clientSocket.jar. ```<br><br>
> **Note**
> You need to manually add in the target folder the file PersonalCard.json to correctly run the server.
> to do this, copy the file from the root of the project to the target folder on run the following command:
> ```bash
> $ cp PersonalCard.json target/
> ```
---


## Start Applications
```bash
# Start Server
$ cd ./target
$ java -jar ing-sw-2023-paganini-tommasi-russo-porfiri-server.jar

# Run the Client  Socket 
$ cd ../ClientSocket
$ java -jar ing-sw-2023-paganini-tommasi-russo-porfiri-clientRMI [ip address] #default ip address is 127.0.0.1 (localhost)

# or Run the Client RMI (or both)
$ cd ../ClientRMI
$ java -jar ing-sw-2023-paganini-tommasi-russo-porfiri-clientSocket [ip address] #default ip address is 127.0.0.1 (localhost)
```


## Gameplay
### Before the game
On the login page, the user is prompted to enter their player username and specify the number of players who will participate in the game.
<br> <br> <br>
![login.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2Flogin.jpg)
<br><br>

If a game with the specified number of players does not exist, a new room will be created for them.
the game support from 2 up to 4 players.

<br><br>


### Graphical Interface guide
<br>

![info component.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2Finfo%20component.jpg)

---

## Examples

---
### Example of a room with 2 players:
<br>

![Game Startup.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Startup.jpg)

If a game with the specified number of players already exists, the player will join that room and wait for additional
users until the room reaches its maximum player capacity, which was determined during the room's creation.
<br><br>

---

### Example of a 3-players game startup:

<br><br>
![Game Startup 3 Players.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Startup%203%20Players.jpg)
<br><br>

---

### Example of a 4-players game startup:
<br>

![Game Startup 4.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Startup%204.jpg)

---

### Game Chat Implementation

Players can send asynchronous messages, regardless of whether it's their turn or not.<br><br>
![Game Chat.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Chat.jpg)
<br><br><br><br>

---
## Exception Handler and Info Messages

<br>

![Game Exception Example1.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Exception%20Example1.jpg)
<br><br>
In this example we have shown the correct removal of a single tile but the order of insertion in the library is not correct!
<br><br>
---

### Players will be notified when it's their turn to play: 
<br><br>
![Game Message Example1.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Message%20Example1.jpg)


---

### Only when it is the player's turn the send button is enabled and the player can draw from the Game board! 

<br>

![Game Send Button Disabled.jpg](src%2Fmain%2Fresources%2FGraphicResources%2Freadmi%20recurce%2FGame%20Send%20Button%20Disabled.jpg)

<br>
---
### After the game
When the game ends, the players will be notified of the winner and the points obtained by each player. After which, he 
will have the opportunity to take a look at their personal shelves and the ones of the other players with the info message.


---
## Contributors
Made with ❤️ by GC28, scaglione professor Cugola.
> **Contact Information** <br>
> mail: [alessio.tommasi@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@AlessioTommasi-polimi](https://github.com/AlessioTommasi-polimi) <br>
> mail: [giampiero.porfiri@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@Giampiero-Porfiri](https://github.com/Giampiero-Porfiri) <br>
> mail: [emanuele.russo@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@EmanueleRuss0](https://github.com/EmanueleRuss0) <br>
> mail: [mattia.paganini@mail.polimi.it] &nbsp;&middot;&nbsp;
> GitHub [@MattiaPaganini](https://github.com/MattiaPaganini) <br>
