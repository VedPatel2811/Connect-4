import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int port;

    public Server(int port){

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Sever is running" + port);
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }

    public void start(){

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected.");
                // Create a new thread for each client (or use a thread pool for efficiency)
                //new Thread(new Server(clientSocket)).start();
            } catch (IOException e) {
                System.out.println("Accept failed.");
                System.exit(-1);
            }
        }
    }
}
