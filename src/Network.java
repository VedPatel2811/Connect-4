import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Network {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean isServer;
    private Model model;
    public ChatBox chatBox;
    private StartGame startGame;

    public Network(Socket socket, boolean isServer, Model model, StartGame startGame) {
        this.socket = socket;
        this.isServer = isServer;
        this.model = model;
        chatBox = new ChatBox(this);
        startGame.chatBox=chatBox;
        this.startGame = startGame;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to send a message to the connected peer
    public void sendMessage(String message) {
        out.println(message);
    }

    // Method to receive a message from the connected peer
    public String receiveMessage() {
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to close the network connection
    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle incoming messages and perform appropriate actions based on the protocol
    public void handleIncomingMessage(String message) {
        String[] parts = message.split("#"); // Split message into protocol ID and data
        int protocolId = Integer.parseInt(parts[0]);
        String data = parts[1];

        switch (protocolId) {
            case 1:
                // Process disconnection message
                // Notify model or view about disconnection
                break;
            case 2:
                if (isServer) {
                    startGame.name2=data;
                } else {
                    startGame.name1=data;
                }
                break;
            case 3:
                // Process move message
                // Update game state in model or view
                break;
            case 4:
                // Process chat message
                chatBox.appendMessage("Opponent: "+data); // Update chat box with received message
                break;
            case 5:
                if(isServer){
                    startGame.player2Token=data;
                }else {
                    startGame.player1Token=data;
                }
            default:
                // Handle unknown protocol
        }
    }
}