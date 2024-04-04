import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the start menu for the Connect Four game.
 * Allows players to enter their names and select their token colors before starting the game.
 */
public class StartGame implements ActionListener {
    /**
     * The token selected for Player 1.
     */
    private String player1Token;

    /**
     * The token selected for Player 2.
     */
    private String player2Token;

    /**
     * The name entered for Player 1.
     */
    private String name1;

    /**
     * The name entered for Player 2.
     */
    private String name2;

    /**
     * The button to start the game.
     */
    private JButton startGame;

    /**
     * The base panel for the start menu.
     */
    private JFrame baseStartPanel;

    /**
     * The text field for entering Player 1's name.
     */
    private JTextField player1Name;

    /**
     * The text field for entering Player 2's name.
     */
    private JTextField player2Name;

    /**
     * The list of available colors for players.
     */
    public ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Orange", "Green", "Blue", "Yellow", "Pink", "Purple", "Black"));

    /**
     * The combo box for selecting Player 1's color.
     */
    public JComboBox<String> player1ColorBox;

    /**
     * The combo box for selecting Player 2's color.
     */
    public JComboBox<String> player2ColorBox;

    /**
     * The instance of the StartGame class.
     */
    private StartGame startGameClass;


    /**
     * Constructs a StartGame object.
     */
    StartGame(){}

    public JFrame StartGameFrame(){
        JFrame startGame = new JFrame();
        startGame.getContentPane().setBackground(new Color(143, 170, 220));
        startGame.setDefaultCloseOperation(startGame.EXIT_ON_CLOSE);
        startGame.setPreferredSize(new Dimension(300, 205));
        startGame.setLayout(new FlowLayout());

        Font font = new Font("Calibri", Font.BOLD, 20);
        JButton offlineOption = new JButton();
        offlineOption.setPreferredSize(new Dimension(250, 75));
        offlineOption.setBackground(new Color(53, 90, 155));
        offlineOption.setFont(font);
        JButton onlineOption = new JButton();
        onlineOption.setPreferredSize(new Dimension(250, 75));
        onlineOption.setBackground(new Color(53, 90, 155));
        onlineOption.setFont(font);
        JLabel offlineLabel = new JLabel("Play Offline");
        offlineLabel.setForeground(Color.YELLOW);
        offlineLabel.setFont(font);
        JLabel onlineLabel = new JLabel("Play Online");
        onlineLabel.setForeground(Color.YELLOW);
        onlineLabel.setFont(font);


        offlineOption.add(offlineLabel);
        onlineOption.add(onlineLabel);

        offlineOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame.dispose();
                Offline(StartGame.this);
            }
        });

        onlineOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame.dispose();
                Online(StartGame.this);
            }
        });

        startGame.add(offlineOption);
        startGame.add(onlineOption);

        startGame.pack();
        startGame.setVisible(true);

        return startGame;
    }

    /**
     * Displays the start menu for the game.
     *
     * @param startGameClass The instance of the StartGame class
     * @return The JFrame containing the start menu
     */
    public JFrame Offline(StartGame startGameClass){
        this.startGameClass = startGameClass;
        baseStartPanel = new JFrame();
        baseStartPanel.getContentPane().setBackground(new Color(143, 170, 220));

        baseStartPanel.setDefaultCloseOperation(baseStartPanel.EXIT_ON_CLOSE);
        baseStartPanel.setPreferredSize(new Dimension(300, 225));

        baseStartPanel.setLayout(new FlowLayout());

        player1Name = Player1Name();
        player2Name = Player2Name();
        startGame = StartGame();
        player1ColorBox = ColorSelection1();
        player2ColorBox = ColorSelection2();
        startGame.addActionListener(this);
        player1ColorBox.addActionListener(this);
        player2ColorBox.addActionListener(this);

        baseStartPanel.add(new JLabel("Player 1 Name "));
        baseStartPanel.add(player1Name);
        baseStartPanel.add(new JLabel("Player 1 Color"));
        baseStartPanel.add(player1ColorBox);
        baseStartPanel.add(new JLabel("Player 2 Name "));
        baseStartPanel.add(player2Name);
        baseStartPanel.add(new JLabel("Player 2 Color"));
        baseStartPanel.add(player2ColorBox);
        baseStartPanel.add(startGame);

        ImageIcon image = new ImageIcon("A12Logo.png");
        baseStartPanel.setIconImage(image.getImage());
        baseStartPanel.pack();
        baseStartPanel.setVisible(true);

        return baseStartPanel;
    }

    public JFrame Online(StartGame startGame){
        JFrame onlineFrame = new JFrame();
        onlineFrame.getContentPane().setBackground(new Color(143, 170, 220));
        onlineFrame.setDefaultCloseOperation(onlineFrame.EXIT_ON_CLOSE);
        onlineFrame.setPreferredSize(new Dimension(300, 205));
        onlineFrame.setLayout(new FlowLayout());

        Font font = new Font("Calibri", Font.BOLD, 20);
        JButton hostButton = new JButton();
        hostButton.setPreferredSize(new Dimension(250, 75));
        hostButton.setBackground(new Color(53, 90, 155));
        hostButton.setFont(font);
        JButton clientButton = new JButton();
        clientButton.setPreferredSize(new Dimension(250, 75));
        clientButton.setBackground(new Color(53, 90, 155));
        clientButton.setFont(font);
        JLabel hostLabel = new JLabel("Host The Game");
        hostLabel.setForeground(Color.YELLOW);
        hostLabel.setFont(font);
        JLabel clientLabel = new JLabel("Join the Game");
        clientLabel.setForeground(Color.YELLOW);
        clientLabel.setFont(font);


        hostButton.add(hostLabel);
        clientButton.add(clientLabel);

        hostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onlineFrame.dispose();
                Offline(StartGame.this);
            }
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onlineFrame.dispose();
                Online(StartGame.this);
            }
        });

        onlineFrame.add(hostButton);
        onlineFrame.add(clientButton);

        onlineFrame.pack();
        onlineFrame.setVisible(true);

        return onlineFrame;
    }

    public void HostFrame(){

    }

    /**
     * Handle actions performed on components
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==player1ColorBox){
            player1Token=(String) player1ColorBox.getSelectedItem();
            colors.remove(player1Token);
            player2ColorBox.setModel(new DefaultComboBoxModel<>(colors.toArray(new String[0])));
        }
        if(e.getSource()==player2ColorBox){
            player2Token=(String) player2ColorBox.getSelectedItem();
            colors.remove(player2Token);
        }
        if(e.getSource()==startGame){
            name1 = player1Name.getText();
            name2 = player2Name.getText();

            baseStartPanel.dispose();
            Main main = new Main();
            main.StartMainGame(name1, name2, player1Token, player2Token, startGameClass);

        }
    }

    /**
     * Creates a text field for entering Player 1's name.
     *
     * @return The JTextField for Player 1's name
     */
    public JTextField Player1Name(){
        JTextField player1Name = new JTextField("Player 1");
        player1Name.setPreferredSize(new Dimension(150, 30));
        player1Name.setBackground(new Color(180,199,231));
        player1Name.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return player1Name;
    }

    /**
     * Creates a text field for entering Player 2's name.
     *
     * @return The JTextField for Player 2's name
     */
    private JTextField Player2Name(){
        JTextField player2Name = new JTextField("Player 2");
        player2Name.setPreferredSize(new Dimension(150, 30));
        player2Name.setBackground(new Color(180,199,231));
        player2Name.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return player2Name;
    }

    /**
     * Creates a combo box for selecting Player 1's token color.
     *
     * @return The JComboBox for selecting Player 1's token color
     */
    public JComboBox<String> ColorSelection1() {
        JComboBox<String> colorBox = new JComboBox<>(colors.toArray(new String[0]));
        colorBox.setPreferredSize(new Dimension(150, 30));
        colorBox.setBackground(new Color(180,199,231));
        colorBox.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        colorBox.setSelectedItem("Red");
        return colorBox;
    }

    /**
     * Creates a combo box for selecting Player 2's token color.
     *
     * @return The JComboBox for selecting Player 2's token color
     */
    private JComboBox<String> ColorSelection2() {
        JComboBox<String> colorBox = new JComboBox<>(colors.toArray(new String[1]));
        colorBox.setPreferredSize(new Dimension(150, 30));
        colorBox.setBackground(new Color(180,199,231));
        colorBox.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        colorBox.setSelectedItem("Black");
        return colorBox;
    }

    /**
     * Creates a button for starting the game.
     *
     * @return The JButton for starting the game
     */
    private JButton StartGame(){
        JButton startButton = new JButton("Start Game");
        startButton.setBackground(new Color(53, 90, 156));
        startButton.setForeground(Color.YELLOW);
        startButton.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        startButton.setPreferredSize(new Dimension(100,30));
        return startButton;
    }

    /**
     * Gets the name of Player 1.
     *
     * @return The name of Player 1
     */
    public String getName1() {
        return name1;
    }

    /**
     * Gets the name of Player 2.
     *
     * @return The name of Player 2
     */
    public String getName2() {
        return name2;
    }


}
