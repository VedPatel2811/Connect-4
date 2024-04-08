import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public Socket socket;
    private String serverAddress;
    private int port;
    private StartGame startGame;
    private Network network;

    public Client(String serverAddress, int port, StartGame startGame) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.startGame=startGame;
    }

    public void connectToServer() {
        boolean connected = false; // Flag to track if the connection is successful

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

    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
