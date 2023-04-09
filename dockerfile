FROM openjdk:19
COPY . /usr/src/SocketClient
WORKDIR /usr/src/SocketClient
RUN javac SocketClient.java
# Can adjust log level from FINE to any of {FINE, INFO, SEVERE, OFF, ALL}
CMD ["java", "-DsocketClientLogLevel=FINE", "SocketClient", "djxmmx.net", "17"]