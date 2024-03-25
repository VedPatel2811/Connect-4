import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {

        StartGame startGame = new StartGame();
        startGame.StartMenu(startGame);

    }
    public void StartMainGame(String name1, String name2, String player1Token, String player2Token, StartGame startGame){
        GameInfo gameInfo = new GameInfo(name1, name2, player1Token, player2Token);
        Model model = new Model(); // Create instance of the Connect4Model
        GameBoard myBoard = new GameBoard(model, player1Token, player2Token); // Pass the model to GameBoard



        MenuBar myBar = new MenuBar(gameInfo);
        JMenuBar menuBar = myBar.createMenuBar();
        Header connect4 = new Header();
        ChatBox myChat = new ChatBox();

        Controller controller = new Controller(model, myBoard, gameInfo, startGame, myBar); // Create instance of the Connect4Controller
        // Inside your main method or where you initialize your game components
        //GameBoard gameBoard = new GameBoard(model, "Red", "Yellow");

        // Set up the main window
        JFrame myFrame = new JFrame();
        myFrame.setLayout(new BorderLayout());

        // Top panel to hold the header and menu
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(143, 170, 220));

        // Bottom panel to hold game information, game board, and chat box
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new Color(143, 170, 220));

        bottomPanel.add(gameInfo.GameInfoPanel());
        bottomPanel.add(myBoard.getBasePanel()); // Use getBasePanel() to get the game board panel
        bottomPanel.add(myChat.MainChatBox());

        topPanel.add(connect4.ConnectHeader());
        topPanel.add(menuBar, BorderLayout.NORTH);
        myFrame.add(topPanel, BorderLayout.NORTH);
        myFrame.add(bottomPanel);

        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(1920, 1080));
        myFrame.setTitle("CONNECT 4");
        myFrame.getContentPane().setBackground(new Color(143, 170, 220));
        ImageIcon image = new ImageIcon("A12Logo.png");
        myFrame.setIconImage(image.getImage());
        myFrame.pack();
        myFrame.setVisible(true);

        myBoard.addChipDropListener(controller.new PlaceToken());
    }
}
