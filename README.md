# SocketClient
Simple TCP socket client for UW networking class.

Usage: `java SocketClient <host> <port> <request body...>`

# Requirements
SocketClient was built and tested on Java 19 on Arch Linux and Oracle Linux (via Docker image). A dockerfile is available but you will need to adjust the `RUN` verb depending on what arguments you want to supply.

# Log levels
You can adjust the log level from FINE to any of {FINE, INFO, SEVERE, OFF, ALL} by adjusting the system variable `socketClientLogLevel` with a command line flag. E.g.: `java -DsocketClientLogLevel=FINE SocketClient time.nist.gov 13`. **The command line arg must come BEFORE SocketClient!**

A log level of OFF will still write the TCP response to stdout because that's the whole point of SocketClient. This is intended behavior.