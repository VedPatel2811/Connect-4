import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int port;

    public Server(int port){
        this.port = port;
    }

    public void start(){
    }
}
