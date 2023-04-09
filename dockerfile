FROM openjdk:19
COPY . /usr/src/SocketClient
WORKDIR /usr/src/SocketClient
RUN javac SocketClient.java
CMD ["java", "SocketClient", "djxmmx.net", "17"]