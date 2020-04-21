import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Client() {
        System.out.println("[CLIENT] created");
    }

    public void startConnection(String ip, int port) {
        try {
            try {
                clientSocket = new Socket(ip, port);
            } catch (ConnectException ex) {
                System.out.println("[CLIENT] Hostname not found!");
                return;
            }
            System.out.println("[CLIENT] Connection to " + ip + ":" + port + " established.");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            System.out.println("[CLIENT] exception thrown: " + ex.getMessage());
        }
    }

    public void sendMessage(String msg) {
        try {
            out.println(msg);
            System.out.println("[CLIENT] message received: " + in.readLine());
        } catch (Exception ex) {
            System.out.println("[CLIENT] exception thrown: " + ex.getMessage());
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception ex) {
            System.out.println("[CLIENT] exception thrown: " + ex.getMessage());
        }
    }
}
