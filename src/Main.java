import javax.swing.*;
import java.awt.*;


/**
 * The Main class sets up the main window for the Connect 4 game.
 * It integrates various components such as the menu bar, header, game information,
 * game board, and chat box into a single JFrame.
 */
public class Main {
    /**
     * The entry point of the application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Model model = new Model(); // Create instance of the Connect4Model
        GameBoard myBoard = new GameBoard(model); // Pass the model to GameBoard
        Controller controller = new Controller(model, myBoard); // Create instance of the Connect4Controller
        GameInfo gameInfo = new GameInfo();

        MenuBar myBar = new MenuBar(gameInfo);
        Header connect4 = new Header();
        ChatBox myChat = new ChatBox();

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
        topPanel.add(myBar.Menu(), BorderLayout.NORTH);
        myFrame.add(topPanel, BorderLayout.NORTH);
        myFrame.add(bottomPanel);

        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(930, 540));
        myFrame.setTitle("CONNECT 4");
        myFrame.getContentPane().setBackground(new Color(143, 170, 220));
        ImageIcon image = new ImageIcon("A12logo.png");
        // Pack the components and make the frame visible
        myFrame.setIconImage(image.getImage());
        myFrame.pack();
        myFrame.setVisible(true);

        myBoard.addChipDropListener(controller.new PlaceToken());
    }
}
