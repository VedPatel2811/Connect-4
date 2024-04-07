import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    public Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private ChatBox chatBox;

    public Server(int port, ChatBox chatBox) {
        try {
            serverSocket = new ServerSocket(port);
            chatBox.appendMessage("Waiting for client to connect...");
            clientSocket = serverSocket.accept();
            chatBox.appendMessage("Client connected!");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            this.chatBox = chatBox;
            startListening();
        } catch (IOException e) {
            chatBox.appendMessage("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void startListening() {
        new Thread(() -> {
            try {
                while (true) {
                    String message = receiveMessage();
                    chatBox.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void close() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            chatBox.appendMessage("Error closing server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
