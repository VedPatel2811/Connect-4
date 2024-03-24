import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * GameInfo class is a part of the Connect-4 game UI, responsible for displaying
 * player information, game time, and other relevant game status information.
 * This class extends JPanel and creates a layered layout to organize this information.
 */
public class GameInfo extends JPanel {
    public Color player1Color = Color.YELLOW;
    public Color player2Color = new Color(32,56,100);
    private JLabel player1TurnLabel;
    private JLabel player2TurnLabel;
    private final String player1Name ;
    private final String player2Name;
    private final String player1TokenColor;
    private final String player2TokenColor;



    private Locale currentLocale;
    private ResourceBundle messages;

    private JLabel roundLabel;
    private JLabel instructionLabel;
    private JLabel timer1Label;
    private JLabel timer2Label;


    // Class-level label components for Player 1
    private JLabel nameLabelPlayer1;
    private JLabel winLabelPlayer1;
    private JLabel turnLabelPlayer1;

    //Class-level label components for Player 2
    private JLabel nameLabelPlayer2;
    private JLabel winLabelPlayer2;
    private JLabel turnLabelPlayer2;
    /**
     * Constructor for GameInfo.
     */

    public GameInfo(String player1Name, String player2Name, String player1Token, String player2Token) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1TokenColor = player1Token;
        this.player2TokenColor = player2Token;


        roundLabel = new JLabel();
        instructionLabel = new JLabel();
        timer1Label = new JLabel();
        timer2Label = new JLabel();
        nameLabelPlayer1 = new JLabel();
        winLabelPlayer1 = new JLabel();
        turnLabelPlayer1 = new JLabel();
        nameLabelPlayer2 = new JLabel();
        winLabelPlayer2 = new JLabel();
        turnLabelPlayer2 = new JLabel();


        currentLocale = new Locale("en", "CA");
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateText();
    }

    // Method to switch to a new locale and update the text
    public void switchLanguage(String languageCode, String countryCode) {
        this.currentLocale = new Locale(languageCode, countryCode);
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateText(); // Update the text components with new locale
    }

    // Method to update all text components with values from the resource bundle
    public void updateText() {

        // Debugging: print the values you're setting to confirm they're correct
        String roundText = messages.getString("round") + " 1.";
        roundLabel.setText(roundText);

        String instructionText = messages.getString("clickToPlay");
        instructionLabel.setText(instructionText);

        String timerText = messages.getString("timer") + ": 22s";
        timer1Label.setText(timerText);

        // Assuming that player names are set separately and should not be updated here
        // since they are not to be translated
        // nameLabelPlayer1.setText(player1Name); // This line remains commented out or removed

        String winTextPlayer1 = messages.getString("player1Wins");
        winLabelPlayer1.setText(winTextPlayer1);

        String turnTextPlayer1 = messages.getString("player1Turn");
        turnLabelPlayer1.setText(turnTextPlayer1);

        // Similar updates for player 2
        // nameLabelPlayer2.setText(player2Name); // This line remains commented out or removed

        String winTextPlayer2 = messages.getString("player2Wins");
        winLabelPlayer2.setText(winTextPlayer2);

        String turnTextPlayer2 = messages.getString("player2Turn");
        turnLabelPlayer2.setText(turnTextPlayer2);

        String gameTimeText = messages.getString("gameTime") + " 3m 11s";
        timer2Label.setText(gameTimeText);

        // Now refresh the UI
        this.revalidate();
        this.repaint();

    }

    /**
     * Creates and returns a JLayeredPane which contains the main components of game info.
     * This includes panels for player information, game time, and other status elements.
     *
     * @return JLayeredPane The main layered panel containing game info components.
     */

    public JLayeredPane GameInfoPanel(){
        JLayeredPane baseLayer = new JLayeredPane();
        baseLayer.setBorder(new EmptyBorder(0,25,0,50));

        JPanel basePanel = BasePanel(player1Color, player2Color);

        baseLayer.setLayout(new FlowLayout());
        baseLayer.setPreferredSize(new Dimension(425, 610));

        baseLayer.add(basePanel);
        return baseLayer;
    }

    /**
     * Creates and returns the base panel for game information.
     * This panel includes other sub-panels for individual player info and time information.
     *
     * @return JPanel The base panel containing all sub-panels for game info.
     */
    private JPanel BasePanel(Color color, Color color2){
        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(425, 560));
        basePanel.setBackground(new Color(68,114,196));
        basePanel.setBorder(new EmptyBorder(25,25,25,25));

        JPanel player1 = Player1(color);
        JPanel player2 = Player2(color2);
        JPanel timeInfo = TimeInfo();

        basePanel.add(player1);
        basePanel.add(player2);
        basePanel.add(timeInfo);
        return basePanel;
    }

    /**
     * Creates and returns a JPanel containing information about Player 1.
     * This includes the player's image, name, win count, and turn status.
     *
     * @return JPanel The panel containing Player 1's information.
     */
    private JPanel Player1(Color color){
        JPanel player1 = new JPanel();
        player1.setBackground(new Color(32,56,100));
        player1.setPreferredSize(new Dimension(175,250));

        ImageIcon myImagePlayer1 = new ImageIcon(imageCases2(player1TokenColor).getImage());
        JLabel imageLabelPlayer1 = new JLabel(myImagePlayer1);

        // Initialize the class-level labels here
        //nameLabelPlayer1 = new JLabel(messages.getString("player1Name")); // Set text from ResourceBundle
        nameLabelPlayer1 = new JLabel(player1Name); // Initialized with default text
        nameLabelPlayer1.setForeground(new Color(124, 150, 199));
        nameLabelPlayer1.setFont(new Font("Calibri", Font.BOLD, 50));

       // winLabelPlayer1 = new JLabel(messages.getString("player1Wins")); // Set text from ResourceBundle
        winLabelPlayer1 = new JLabel("Player 1"); // Initialized with default text
        winLabelPlayer1.setForeground(new Color(124, 150, 199));
        winLabelPlayer1.setFont(new Font("Calibri", Font.BOLD, 35));

        //turnLabelPlayer1 = new JLabel(messages.getString("player1Turn")); // Set text from ResourceBundle
        turnLabelPlayer1 = new JLabel("Your Turn"); // Initialized with default text
        turnLabelPlayer1.setForeground(color);
        turnLabelPlayer1.setFont(new Font("Calibri", Font.BOLD, 30));

        // Add to the panel
        player1.add(imageLabelPlayer1);
        player1.add(nameLabelPlayer1);
        player1.add(winLabelPlayer1);
        player1.add(turnLabelPlayer1);
        player1TurnLabel = turnLabelPlayer1;

        return player1;
    }

    /**
     * Creates and returns a JPanel containing information about Player 2.
     * This includes the player's image, name, win count, and turn status.
     *
     * @return JPanel The panel containing Player 2's information.
     */
    private JPanel Player2(Color color){
        JPanel player2 = new JPanel();
        player2.setBackground(new Color(32,56,100));
        player2.setPreferredSize(new Dimension(175,250));

        ImageIcon myImagePlayer2 = new ImageIcon(imageCases2(player2TokenColor).getImage());
        JLabel imageLabelPlayer2 = new JLabel(myImagePlayer2);

        player2.add(imageLabelPlayer2);


        //JLabel nameLabel = new JLabel("Ved");
        nameLabelPlayer2 = new JLabel(player2Name);
       // nameLabelPlayer2 = new JLabel(messages.getString("player2Name")); // Set text from ResourceBundle
        nameLabelPlayer2.setVerticalTextPosition(JLabel.BOTTOM);
        nameLabelPlayer2.setForeground(new Color(124, 150, 199));
        nameLabelPlayer2.setFont(new Font("Calibri", Font.BOLD, 50));

        //JLabel winLabel = new JLabel("0 Win");
        winLabelPlayer2 = new JLabel("Player 2");
       // winLabelPlayer2 = new JLabel(messages.getString("player1Wins")); // Set text from ResourceBundle
        winLabelPlayer2.setForeground(new Color(124, 150, 199));
        winLabelPlayer2.setFont(new Font("Calibri", Font.BOLD, 35));

        //JLabel turnLabel = new JLabel("Your Turn");
        turnLabelPlayer2 = new JLabel("Your Turn");
        //turnLabelPlayer2 = new JLabel(messages.getString("player1Turn")); // Set text from ResourceBundle
        turnLabelPlayer2.setForeground(color);
        turnLabelPlayer2.setFont(new Font("Calibri", Font.BOLD, 30));

        player2.add(imageLabelPlayer2);
        player2.add(nameLabelPlayer2);
        player2.add(winLabelPlayer2);
        player2.add(turnLabelPlayer2);
        player2TurnLabel = turnLabelPlayer2;
        return player2;
    }

    /**
     * Creates and returns a JPanel containing the game time information.
     * This includes round number, instructions, and timers.
     *
     * @return JPanel The panel containing the time information for the game.
     */
    private JPanel TimeInfo(){
        JPanel timeInfo = new JPanel();
        timeInfo.setBackground(new Color(32,56,100));
        timeInfo.setPreferredSize(new Dimension(355, 250));

        //JLabel round = new JLabel();
        //roundLabel.setText("Round 1.");
        roundLabel = new JLabel("Round 1."); // Default text, will be updated later
        roundLabel.setHorizontalAlignment(JLabel.LEFT);
        roundLabel.setForeground(new Color(124, 150, 199));
        roundLabel.setFont(new Font("Calibri", Font.BOLD, 40));


        //JLabel instruction = new JLabel();
        instructionLabel = new JLabel("Click on a column to make your move.");
        //instruction.setText("Click on a column to make your move.");
        instructionLabel.setForeground(new Color(124, 150, 199));
        instructionLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        instructionLabel.setHorizontalAlignment(SwingConstants.LEFT);

        //JLabel timer1 = new JLabel();
        //timer1.setText("Timer: 22s");
        timer1Label = new JLabel("Timer: 22s"); // Default text, will be updated later
        timer1Label.setForeground(new Color(124, 150, 199));
        timer1Label.setFont(new Font("Calibri", Font.BOLD, 40));
        timer1Label.setHorizontalAlignment(SwingConstants.LEFT);

        //JLabel timer2 = new JLabel();
        //timer2.setText("Game time: 3m 11s");
        timer2Label = new JLabel("Game time: 3m 11s"); // Default text, will be updated later
        timer2Label.setForeground(new Color(124, 150, 199));
        timer2Label.setFont(new Font("Calibri", Font.BOLD, 30));
        timer2Label.setHorizontalAlignment(SwingConstants.LEFT);


        timeInfo.add(roundLabel);
        timeInfo.add(instructionLabel);
        timeInfo.add(Box.createRigidArea(new Dimension(350,50)));
        timeInfo.add(timer1Label);
        timeInfo.add(timer2Label);

        return timeInfo;
    }

    public JLabel getPlayer1TurnLabel() {
        return player1TurnLabel;
    }
    public JLabel getPlayer2TurnLabel() {
        return player2TurnLabel;
    }

    private ImageIcon imageCases2(String playerToken){
        ImageIcon playerTokenImage = null;
        switch (playerToken){ //"Red", "Orange", "Green", "Blue", "Yellow", "Pink", "Purple", "Black"
            case "Red":
                playerTokenImage = new ImageIcon("A12Red2.png");
                break;
            case "Orange":
                playerTokenImage = new ImageIcon("A12Orange2.png");
                break;
            case "Green":
                playerTokenImage = new ImageIcon("A12Green2.png");
                break;
            case "Blue":
                playerTokenImage = new ImageIcon("A12Blue2.png");
                break;
            case "Yellow":
                playerTokenImage = new ImageIcon("A12Yellow2.png");
                break;
            case "Pink":
                playerTokenImage = new ImageIcon("A12Pink2.png");
                break;
            case "Purple":
                playerTokenImage = new ImageIcon("A12Purple2.png");
                break;
            case "Black":
                playerTokenImage = new ImageIcon("A12Black2.png");
                break;
        }
        return playerTokenImage;
    }
}