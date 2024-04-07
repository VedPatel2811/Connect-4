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

    public int hostPort;
    public int clientPort;

    private JTextField hostPortField;
    private JTextField clientPortField;

    public JLabel status;
    public JTextField address;
    public String hostAddress;

    private JButton hostButton;
    private JButton clientButton;
    private JButton cancel;
    private JFrame clientFrame;
    private JFrame hostFrame;
    private Server gameServer;
    private Client gameClient;



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
        startGame = Button("Start Game");
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

        ImageIcon image = new ImageIcon("resources/A12Logo.png");
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
                HostFrame();
            }
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onlineFrame.dispose();
                ClientFrame();
            }
        });

        onlineFrame.add(hostButton);
        onlineFrame.add(clientButton);

        onlineFrame.pack();
        onlineFrame.setVisible(true);

        return onlineFrame;
    }

    public void HostFrame(){
        hostFrame = new JFrame();
        hostFrame.getContentPane().setBackground(new Color(143, 170, 220));
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setPreferredSize(new Dimension(300, 250));

        hostFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);

        player1Name = Player1Name();
        player1ColorBox = ColorSelection1();
        player1ColorBox.addActionListener(this);
        hostPortField = getPort();

        gbc.gridx = 0;
        gbc.gridy = 0;
        hostFrame.add(new JLabel("Name: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        hostFrame.add(player1Name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        hostFrame.add(new JLabel("Color: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        hostFrame.add(player1ColorBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        hostFrame.add(new JLabel("Port: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        hostFrame.add(hostPortField, gbc);

        status = new JLabel("Status: ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        hostFrame.add(status, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        hostButton = Button("Host");
        hostButton.addActionListener(this);
        hostFrame.add(hostButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        cancel = Button("Cancel");
        cancel.addActionListener(this);
        hostFrame.add(cancel, gbc);

        hostFrame.pack();
        hostFrame.setVisible(true);
    }

    public void ClientFrame(){
        clientFrame = new JFrame();
        clientFrame.getContentPane().setBackground(new Color(143, 170, 220));
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.setPreferredSize(new Dimension(300, 275));

        clientFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);

        player2Name = Player1Name();
        player2ColorBox = ColorSelection1();
        player2ColorBox.addActionListener(this);
        clientPortField = getPort();
        address = address();


        gbc.gridx = 0;
        gbc.gridy = 0;
        clientFrame.add(new JLabel("Name: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        clientFrame.add(player2Name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        clientFrame.add(new JLabel("Color: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        clientFrame.add(player2ColorBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        clientFrame.add(new JLabel("Address: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        clientFrame.add(address,gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        clientFrame.add(new JLabel("Port: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        clientFrame.add(clientPortField, gbc);

        status = new JLabel("Status: ");
        gbc.gridx = 0;
        gbc.gridy = 4;
        clientFrame.add(status, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        clientButton = Button("Connect");
        clientButton.addActionListener(this);
        clientFrame.add(clientButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        cancel = Button("Cancel");
        cancel.addActionListener(this);
        clientFrame.add(cancel, gbc);

        clientFrame.pack();
        clientFrame.setVisible(true);
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
            //player2ColorBox.setModel(new DefaultComboBoxModel<>(colors.toArray(new String[0])));
        }
        if(e.getSource()==player2ColorBox){
            player2Token=(String) player2ColorBox.getSelectedItem();
            colors.remove(player2Token);
        }
        if (player1Token == null) {
            player1Token = "Red"; // Default value if player1Token is still null
        }
        if (player2Token == null) {
            player2Token = "Black"; // Default value if player2Token is still null
        }
        if(e.getSource()==hostButton){
            name1 = player1Name.getText();
            try {
                hostPort = Integer.parseInt(hostPortField.getText());
                startServer();
                hostFrame.dispose();
            } catch (NumberFormatException ex) {
                status.setText("Status: Invalid Port");
            }

        }
        if(e.getSource()==clientButton){
            name2 = player2Name.getText();

            try {
                hostAddress = address.getText();
                try {
                    clientPort = Integer.parseInt(clientPortField.getText());
                    connectToServer();
                    clientFrame.dispose();
                } catch (NumberFormatException ex) {
                    status.setText("Status: Invalid Port");
                }
            } catch (NumberFormatException ex) {
                status.setText("Status: Invalid Address");
            }


        }
        if (e.getSource()==cancel){
            if(clientFrame!=null){
                clientFrame.dispose();
            } else if (hostFrame!=null) {
                hostFrame.dispose();
            }
            StartGameFrame();
        }
        if(e.getSource()==startGame){
            name1 = player1Name.getText();
            name2 = player2Name.getText();

            baseStartPanel.dispose();
            Main main = new Main();
            main.StartMainGame(name1, name2, player1Token, player2Token, startGameClass);

        }
        if (e.getSource() == hostButton || e.getSource() == clientButton) {
            Main main = new Main();
            main.StartMainGame(name1, name2, player1Token, player2Token, startGameClass);
        }
    }

    public JTextField address(){
        JTextField address = new JTextField("localhost");
        address.setPreferredSize(new Dimension(150, 30));
        address.setBackground(new Color(180,199,231));
        address.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return address;
    }

    public JTextField getPort(){
        JTextField port = new JTextField("4999");
        port.setPreferredSize(new Dimension(150, 30));
        port.setBackground(new Color(180,199,231));
        port.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return port;
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
        colorBox.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));colorBox.setSelectedItem("Red");
        colorBox.setSelectedIndex(0);
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
        colorBox.setSelectedIndex(7);
        return colorBox;
    }

    /**
     * Creates a button for starting the game.
     *
     * @return The JButton for starting the game
     */
    private JButton Button(String buttonName){
        JButton startButton = new JButton(buttonName);
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

    public void startServer() {
        gameServer = new Server(hostPort);
        gameServer.startServer();
    }

    public void connectToServer() {
        gameClient = new Client(hostAddress, clientPort);
        gameClient.connectToServer();
    }

    public void closeServer() {
        if (gameServer != null) {
            gameServer.closeServer();
        }
    }

    public void closeClientConnection() {
        if (gameClient != null) {
            gameClient.closeConnection();
        }
    }

}