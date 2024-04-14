import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

/**
 * A class representing a client for connecting to a server.
 */
public class Client {

    /**
     * Socket for communication with the server
     */
    public Socket socket;

    /**
     * Address of the server
     */
    private String serverAddress;

    /**
     * Port number of the server
     */
    private int port;

    /**
     * Reference to the StartGame instance for initializing the game
     */
    private StartGame startGame;

    /**
     * Network object for sending and receiving messages
     */
    public Network network;

    /**
     * Constructs a new Client instance.
     * @param serverAddress The address of the server.
     * @param port The port number of the server.
     * @param startGame The StartGame instance associated with this client.
     */
    public Client(String serverAddress, int port, StartGame startGame) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.startGame=startGame;
    }

    /**
     * Connects to the server.
     */
    public void connectToServer() {
        boolean connected = false;

        while (!connected) {
            try {
                socket = new Socket(serverAddress, port);
                System.out.println("Connected to server.");

                network = new Network(socket, false, startGame.model, startGame);

                network.sendMessage("2#" + startGame.name2);
                if (startGame.player2Token == null) {
                    network.sendMessage("5#Black");
                } else {
                    network.sendMessage("5#" + startGame.player2Token);
                }

                // Start a thread to listen for incoming messages
                new Thread(() -> {
                    while (true) {
                        String message = network.receiveMessage();
                        if (message != null) {
                            network.handleIncomingMessage(message);
                        }
                    }
                }).start();
               connected = true;
            } catch (IOException e) {
                e.printStackTrace();
                startGame.status.setText("Status: Invalid INFO");
                serverAddress = JOptionPane.showInputDialog("Invalid address. Enter server address:");
                if (serverAddress == null) {
                    break;
                }
                String portStr = JOptionPane.showInputDialog("Invalid port. Enter port:");
                if (portStr == null) {
                    break;
                }
                port = Integer.parseInt(portStr);
            }
        }
    }

    /**
     * Closes the connection to the server.
     */
    public void closeConnection() {
        try {
            socket.close();
            network.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}