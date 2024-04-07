import java.io.*;
import java.net.*;

public class Client {
    public Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private ChatBox chatBox;

    public Client(String address, int port, ChatBox chatBox) {
        try {
            socket = new Socket(address, port);
            chatBox.appendMessage("Connected to host!");

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            this.chatBox = chatBox;
            startListening();
        } catch (IOException e) {
            chatBox.appendMessage("Error connecting to host: " + e.getMessage());
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
                    chatBox.appendMessage(message);
                }
            } catch (IOException e) {
                chatBox.appendMessage("Error receiving message: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            chatBox.appendMessage("Error closing client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
