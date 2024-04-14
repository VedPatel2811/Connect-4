import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Manages the network communication between clients and servers in the Connect 4 game.
 */
public class Network {

    /**
     * Socket for network communication
     */
    private Socket socket;

    /**
     * Output stream for sending messages
     */
    private PrintWriter out;

    /**
     * Input stream for receiving messages
     */
    private BufferedReader in;

    /**
     * Indicates whether the instance is running as a server
     */
    private boolean isServer;

    /**
     * to identify that the local player is a host or a server
     */
    public int localPlayer;

    /**
     * Reference to the game model
     */
    private Model model;

    /**
     * Reference to the chat box component
     */
    public ChatBox chatBox;

    /**
     * Reference to the StartGame instance
     */
    private StartGame startGame;

    /**
     * Constructs a Network object with the specified parameters.
     *
     * @param socket    The socket for network communication.
     * @param isServer  Indicates whether the instance is running as a server.
     * @param model     Reference to the game model.
     * @param startGame Reference to the StartGame instance.
     */
    public Network(Socket socket, boolean isServer, Model model, StartGame startGame) {
        this.socket = socket;
        this.isServer = isServer;
        this.model = model;
        chatBox = new ChatBox(this);
        this.startGame = startGame;
        startGame.chatBox=chatBox;

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isServer){
            localPlayer = 1;
        }else {
            localPlayer = 2;
        }

    }

    /**
     * Sends a message over the network.
     *
     * @param message The message to be sent.
     */
    public void sendMessage(String message) {
        out.println(message);
    }

    /**
     * Receives a message from the network.
     *
     * @return The received message.
     */
    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Closes the network connection.
     */
    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles an incoming message received from the network.
     *
     * @param message The incoming message.
     */
    public void handleIncomingMessage(String message) {
        String[] parts = message.split("#");
        int protocolId = Integer.parseInt(parts[0]);
        String data = parts[1];

        switch (protocolId) {
            case 1: // Protocol 1: Close the game
                if(isServer){
                    startGame.gameServer.closeServer();
                }else {
                    startGame.gameClient.closeConnection();
                }
                System.exit(0);
                break;
            case 2: // Protocol 2: Set player names
                if (isServer) {
                    startGame.name2=data;
                } else {
                    startGame.name1=data;
                }
                break;
            case 3: // Protocol 3: Place token on the board
                int column = Integer.parseInt(data);
                if(model.getCurrentPlayer()!=localPlayer){
                    model.placeToken(column);
                    startGame.myBoard.updateBoard();
                    if (model.checkForWinner()) {
                        startGame.controller.taskForWinner();
                    } else if (model.isColumnFull()) {
                        startGame.controller.view.showDraw();
                    } else {
                        startGame.controller.notTaskForWinner();
                    }
                }
                break;
            case 4: // Protocol 4: Receive chat message
                if(isServer){
                    chatBox.appendMessage(startGame.name2 + " : " +data); // Update chat box with received message
                }else {
                    chatBox.appendMessage(startGame.name1 + " : " +data); // Update chat box with received message
                }

                break;
            case 5: // Protocol 5: Set player tokens
                if(isServer){
                    startGame.player2Token=data;
                }else {
                    startGame.player1Token=data;
                }
                break;
            case 6: // Protocol 6: Reset the game
                startGame.controller.resetGame();
                break;
            default:
                break;
        }
    }
}