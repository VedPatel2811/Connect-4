import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;
    private String serverAddress;
    private int port;

    public Client(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }

    public void connectToServer() {
        try {
            socket = new Socket(serverAddress, port);
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
