import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server(int port) {
        start(port);
        System.out.println("[SERVER] created");
    }

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("[SERVER] listening on port " + port);
            clientSocket = serverSocket.accept();
            System.out.println("[SERVER] connected");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String input = in.readLine();
            while (!clientSocket.isClosed()) {
                if (input != null) {
                    System.out.println("[SERVER] message received: " + input);
                    out.println(input + " back");
                }
                input = in.readLine();
            }
        } catch (Exception ex) {
            System.out.println("[SERVER] exception thrown: " + ex.getMessage());
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception ex) {
            System.out.println("[SERVER] exception thrown: " + ex.getMessage());
        }
    }
}