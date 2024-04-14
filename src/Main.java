import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main class for the Connect 4 game application.
 * This class contains the main method for launching the game and initializing its components.
 */
public class Main {

    /**
     * Main Frame instance
     */
    public JFrame myFrame;
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

        SplashScreen splashScreen = new SplashScreen();
        splashScreen.showSplashScreen();
        StartGame startGame = new StartGame();
        startGame.Online(startGame);

    }

    /**
     * Initializes and starts the main game window with the specified components.
     *
     * @param myBoard The game board component.
     * @param gameInfo The game information component.
     * @param controller The controller managing user interactions and game logic.
     * @param myBar The menu bar component.
     * @param myChat The chat box component.
     */
    public void StartMainGame(GameBoard myBoard, GameInfo gameInfo, Controller controller, MenuBar myBar, ChatBox myChat){

        JMenuBar menuBar = myBar.createMenuBar();
        Header connect4 = new Header();

        myFrame = new JFrame();
        myFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(143, 170, 220));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new Color(143, 170, 220));

        bottomPanel.add(gameInfo.GameInfoPanel());
        bottomPanel.add(myBoard.getBasePanel());
        bottomPanel.add(myChat.MainChatBox());

        JScrollPane scrollPane = new JScrollPane(bottomPanel);
        scrollPane.setBorder(null);

        topPanel.add(connect4.ConnectHeader());
        topPanel.add(menuBar, BorderLayout.NORTH);
        myFrame.add(topPanel, BorderLayout.NORTH);
        myFrame.add(scrollPane);


        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        myFrame.setPreferredSize(new Dimension(1920, 1080));
        myFrame.setTitle("CONNECT 4");
        myFrame.getContentPane().setBackground(new Color(143, 170, 220));
        ImageIcon image = new ImageIcon("resources/A12Logo.png");
        myFrame.setIconImage(image.getImage());
        myFrame.pack();
        myFrame.setVisible(true);

        myBoard.addChipDropListener(controller.new PlaceToken());
    }
}