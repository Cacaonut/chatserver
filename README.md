# Chatserver
Simple Chatserver using Java Sockets

## Prerequisites
**Download Java:** https://www.java.com/de/download/win10.jsp \
**Download BlueJ:** https://www.bluej.org/

*NOTE: During development JetBrains IntelliJ Ultimate Edition was used. Therefore cloning this repository will most likely not work with other IDEs but the source code may be used nonetheless.*

## Classes
**Server:** [Click here...](https://github.com/Cacaonut/chatserver/blob/master/src/Server.java)\
**Client:** [Click here...](https://github.com/Cacaonut/chatserver/blob/master/src/Client.java)

## Usage with other IDE than BlueJ
To use this project in other IDEs than BlueJ you'll need a main method like seen in [Test.java](https://github.com/Cacaonut/chatserver/blob/master/src/Test.java).

Following code may be used to instantiate a server on localhost:555 and a client and connect them:
```java
new Thread(() -> {
    new Server(555);
}).start();

Client client = new Client();
client.startConnection("127.0.0.1", 555);
```
