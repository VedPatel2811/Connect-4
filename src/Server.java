import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Manages the server-side functionality of the Connect 4 game.
 */
public class Server {

    /**
     * The server socket used for handling incoming connections.
     */
    private ServerSocket serverSocket;

    /**
     * The socket representing the client connection.
     */
    public Socket clientSocket;

    /**
     * The port number on which the server listens for incoming connections.
     */
    private int port;

    /**
     * Reference to the StartGame instance associated with the server.
     */
    private StartGame startGame;

    /**
     * The Network object responsible for managing communication with the client.
     */
    public Network network;


    /**
     * Constructs a Server object with the specified port and StartGame instance.
     *
     * @param port      The port number on which the server listens for connections.
     * @param startGame Reference to the StartGame instance.
     */
    public Server(int port, StartGame startGame) {
        this.port = port;
        this.startGame=startGame;
    }

    /**
     * Starts the server and waits for client connections.
     */
    public void startServer() {
        try {

            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for client to connect...");
            clientSocket = serverSocket.accept(); // Waits for client connection
            System.out.println("Client connected.");
            network = new Network(clientSocket, true, startGame.model, startGame);
            network.sendMessage("2#"+startGame.name1);
            if(startGame.player1Token==null){
                network.sendMessage(("5#Red"));
            }else {
                network.sendMessage(("5#"+startGame.player1Token));
            }

            new Thread(() -> {
                while (true) {
                    String message = network.receiveMessage();
                    if (message != null) {
                        network.handleIncomingMessage(message);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the server and cleans up resources.
     */
    public void closeServer() {
        try {
            serverSocket.close();
            network.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}