import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public Socket clientSocket;
    private int port;
    private StartGame startGame;
    public Network network;
    public Server(int port, StartGame startGame) {
        this.port = port;
        this.startGame=startGame;
    }

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

    public void closeServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}