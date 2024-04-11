import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main class for the Connect 4 game application.
 * This class contains the main method for launching the game and initializing its components.
 */
public class Main {

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

        //SplashScreen splashScreen = new SplashScreen();
        //splashScreen.showSplashScreen();
        StartGame startGame = new StartGame();
        startGame.Online(startGame);

    }


    public void StartMainGame(GameBoard myBoard, GameInfo gameInfo, Controller controller, MenuBar myBar, ChatBox myChat, StartGame startGame){

        JMenuBar menuBar = myBar.createMenuBar();
        Header connect4 = new Header();

        // Set up the main window
        myFrame = new JFrame();
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

        // Wrap the bottom panel in a scroll pane
        JScrollPane scrollPane = new JScrollPane(bottomPanel);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        scrollPane.setBorder(null);

        topPanel.add(connect4.ConnectHeader());
        topPanel.add(menuBar, BorderLayout.NORTH);
        myFrame.add(topPanel, BorderLayout.NORTH);
        myFrame.add(scrollPane); // Add scroll pane instead of bottom panel directly


        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
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