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
        // Initialize all the components required for the game
        MenuBar myBar = new MenuBar();
        Header connect4 = new Header();
        GameInfo gameInfo = new GameInfo();
        GameBoard myBoard = new GameBoard();
        ChatBox myChat = new ChatBox();

        // Set up the main window
        JFrame myFrame = new JFrame();
        myFrame.setLayout(new BorderLayout());

        // Top panel to hold the header and menu
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(143,170,220));

        // Bottom panel to hold game information, game board, and chat box
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new Color(143,170,220));

        // Adding game info, game board, and chat box to the bottom panel
        bottomPanel.add(gameInfo.GameInfoPanel());
        bottomPanel.add(myBoard.MainGameBoard());
        bottomPanel.add(myChat.MainChatBox());
        //bottomPanel.add(emptyPanel,BorderLayout.SOUTH);

        // Adding header and menu to the top panel
        topPanel.add(connect4.ConnectHeader());
        topPanel.add(myBar.Menu(),BorderLayout.NORTH);
        myFrame.add(topPanel, BorderLayout.NORTH);
        myFrame.add(bottomPanel);

        // Frame settings
        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(1920,1080));
        myFrame.setTitle("CONNECT 4");
        myFrame.getContentPane().setBackground(new Color(143,170,220));
        // Setting an icon for the application
        ImageIcon image = new ImageIcon("A12logo.png");
        // Pack the components and make the frame visible
        myFrame.setIconImage(image.getImage());
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setResizable(false);
    }
}