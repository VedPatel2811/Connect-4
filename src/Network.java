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
    public int localPlayer;
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
        if(isServer){
            localPlayer = 1;
        }else {
            localPlayer = 2;
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
                startGame.gameServer.closeServer();
                startGame.gameClient.closeConnection();
                System.exit(0);
                break;
            case 2:
                if (isServer) {
                    startGame.name2=data;
                } else {
                    startGame.name1=data;
                }
                break;
            case 3:
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
            case 4:
                if(isServer){
                    chatBox.appendMessage(startGame.name2 + " : " +data); // Update chat box with received message
                }else {
                    chatBox.appendMessage(startGame.name1 + " : " +data); // Update chat box with received message
                }

                break;
            case 5:
                if(isServer){
                    startGame.player2Token=data;
                }else {
                    startGame.player1Token=data;
                }
                break;
            case 6:
                startGame.controller.resetGame();
            default:
                // Handle unknown protocol
        }
    }
}