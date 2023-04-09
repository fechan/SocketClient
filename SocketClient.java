import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import java.util.Arrays;
import java.util.logging.Level;

class SocketClient {
    public static void main(String[] args) {
        String server = args[0];
        int port = Integer.parseInt(args[1]);

        // command line arg: -DsocketClientLogLevel=SEVERE (or INFO or FINE or ALL or OFF)
        Logger logger = Logger.getLogger(SocketClient.class.getName());
        String logLevel = System.getProperty("socketClientLogLevel");
        if (logLevel != null) {
            logger.setLevel(Level.parse(logLevel));
        }

        // consume args 3+ as a single string
        String request = null;
        if (args.length > 2) {
            request = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
        }

        logger.log(Level.INFO, "Attempting to create socket at '" + server + ":" + port + "''...");
        try (Socket sock = new Socket(server, port)) {
            logger.log(Level.INFO, "Socket created!");

            logger.log(Level.FINE, "No request body specified. Skipping write...");
            if (request != null) {
                logger.log(Level.INFO, "Writing request to socket...");
                OutputStream sockOut = sock.getOutputStream(); // write to socket
                sockOut.write(request.getBytes());
            }
            
            logger.log(Level.INFO, "Reading response from socket...");
            InputStream sockIn = sock.getInputStream(); // read from socket
            int nextByte;
            while ((nextByte = sockIn.read()) != -1) {
                System.out.print((char) nextByte);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Oh!! My god!! IOException occurred while socket was being created/used!");
        }
        logger.log(Level.INFO, "Socket closed. Goodbye!");
    }
}