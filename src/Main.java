import javax.swing.*;
import java.awt.*;

/**
 * Main class for the Connect 4 game application.
 * This class contains the main method for launching the game and initializing its components.
 */
public class Main {

    /**
     * Default Constructor
     */
    Main(){}
    /**
     * Main method to start the Connect 4 game.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        //SplashScreen splashScreen = new SplashScreen();
        //splashScreen.showSplashScreen();
        StartGame startGame = new StartGame();
        startGame.StartGameFrame();

    }

    /**
     * Starts the main game with specified player names, player tokens, and game components.
     *
     * @param name1        The name of player 1
     * @param name2        The name of player 2
     * @param player1Token The token for player 1
     * @param player2Token The token for player 2
     * @param startGame    The instance of StartGame class
     */
    public void StartMainGame(String name1, String name2, String player1Token, String player2Token, StartGame startGame){
        GameInfo gameInfo = new GameInfo(name1, name2, player1Token, player2Token);
        Model model = new Model(); // Create instance of the Connect4Model
        GameBoard myBoard = new GameBoard(model, player1Token, player2Token); // Pass the model to GameBoard



        MenuBar myBar = new MenuBar(gameInfo);
        JMenuBar menuBar = myBar.createMenuBar();
        Header connect4 = new Header();
        ChatBox myChat = new ChatBox();

        Controller controller = new Controller(model, myBoard, gameInfo, startGame, myBar); // Create instance of the Connect4Controller

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