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

    /**
     * Add serialVersionUID
     */
    private static final long serialVersionUID = 1L; // Add serialVersionUID
    /**
     * Represents the color of Player 1's token.
     */
    public Color player1Color = Color.YELLOW;

    /**
     * Represents the color of Player 2's token.
     */
    public Color player2Color = new Color(32,56,100);

    /**
     * Label indicating Player 1's turn.
     */
    private JLabel player1TurnLabel;

    /**
     * Label indicating Player 2's turn.
     */
    private JLabel player2TurnLabel;

    /**
     * The name of Player 1.
     */
    private final String player1Name;

    /**
     * The name of Player 2.
     */
    private final String player2Name;

    /**
     * The color of Player 1's token.
     */
    private final String player1TokenColor;

    /**
     * The color of Player 2's token.
     */
    private final String player2TokenColor;

    /**
     * The current locale used for localization.
     */
    public Locale currentLocale;

    /**
     * Resource bundle for internationalization.
     */
    private transient ResourceBundle messages;

    /**
     * Label displaying the round number.
     */
    private JLabel roundLabel;

    /**
     * Label displaying game instructions.
     */
    private JLabel instructionLabel;

    /**
     * Label displaying Player 1's timer.
     */
    public JLabel timer1Label;

    /**
     * Label displaying Player 2's timer.
     */
    public JLabel timer2Label;

    /**
     * Label displaying Player 1's name.
     */
    private JLabel nameLabelPlayer1;

    /**
     * Label displaying Player 1's win status.
     */
    private JLabel winLabelPlayer1;

    /**
     * Label displaying Player 1's turn status.
     */
    private JLabel turnLabelPlayer1;

    /**
     * Label displaying Player 2's name.
     */
    private JLabel nameLabelPlayer2;

    /**
     * Label displaying Player 2's win status.
     */
    private JLabel winLabelPlayer2;

    /**
     * Label displaying Player 2's turn status.
     */
    private JLabel turnLabelPlayer2;

    /**
     * The duration of each player's turn in seconds.
     */
    public int playerTurnTime = 40; // 40 seconds for each player's turn

    /**
     * The total duration of the game in seconds.
     */
    public int gameTime = 240; // 4 minutes for the game

    /**
     * The current round number.
     */
    public int round = 1;


    /**
     * GameInfo Constructor
     * @param player1Name player 1 name
     * @param player2Name player 2 name
     * @param player1Token player 1 Token
     * @param player2Token player 2 Token
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
        currentLocale = Locale.CANADA;
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateText();


    }

    /**
     * Switches the language of the game interface to the specified language and country.
     *
     * @param languageCode The language code (e.g., "en" for English, "fr" for French)
     * @param countryCode  The country code (e.g., "US" for United States, "FR" for France)
     */
    public void switchLanguage(String languageCode, String countryCode) {
        this.currentLocale = new Locale.Builder().setLanguage(languageCode).setRegion(countryCode).build();
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateText(); // Update the text components with new locale
    }


    /**
     * Updates the text content of various labels in the game interface.
     * This method is typically called to reflect changes such as round updates,
     * turn instructions, player names, timer updates, and game outcome messages.
     * The UI components are refreshed to reflect the changes.
     */
    public void updateText() {

        // Debugging: print the values you're setting to confirm they're correct
        String roundText = messages.getString("round") + " "+round;
        roundLabel.setText(roundText);

        String instructionText = messages.getString("clickToPlay");
        instructionLabel.setText(instructionText);

        String timerText = messages.getString("timer") + ": " + playerTurnTime + "s";
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

        String gameTimeText = messages.getString("gameTime") + formatTime(gameTime);
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

        roundLabel = new JLabel("Round " + round);
        roundLabel.setHorizontalAlignment(JLabel.LEFT);
        roundLabel.setForeground(new Color(124, 150, 199));
        roundLabel.setFont(new Font("Calibri", Font.BOLD, 40));


        //JLabel instruction = new JLabel();
        instructionLabel = new JLabel("Click on a column to make your move.");
        //instruction.setText("Click on a column to make your move.");
        instructionLabel.setForeground(new Color(124, 150, 199));
        instructionLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        instructionLabel.setHorizontalAlignment(SwingConstants.LEFT);

        timer1Label = new JLabel("Timer: "+playerTurnTime+"s");
        timer1Label.setForeground(new Color(124, 150, 199));
        timer1Label.setFont(new Font("Calibri", Font.BOLD, 40));
        timer1Label.setHorizontalAlignment(SwingConstants.LEFT);

        timer2Label = new JLabel("Game time: " + formatTime(gameTime));
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

    /**
     * Retrieves the label indicating Player 1's turn.
     *
     * @return The label indicating Player 1's turn
     */
    public JLabel getPlayer1TurnLabel() {
        return player1TurnLabel;
    }
    /**
     * Retrieves the label indicating Player 2's turn.
     *
     * @return The label indicating Player 2's turn
     */
    public JLabel getPlayer2TurnLabel() {
        return player2TurnLabel;
    }

    /**
     * Generates an image icon based on the provided player token.
     *
     * @param playerToken The player's token
     * @return The corresponding image icon
     */
    private ImageIcon imageCases2(String playerToken){
        ImageIcon playerTokenImage = null;
        switch (playerToken){ //"Red", "Orange", "Green", "Blue", "Yellow", "Pink", "Purple", "Black"
            case "Red":
                playerTokenImage = new ImageIcon("resources/A12Red2.png");
                break;
            case "Orange":
                playerTokenImage = new ImageIcon("resources/A12Orange2.png");
                break;
            case "Green":
                playerTokenImage = new ImageIcon("resources/A12Green2.png");
                break;
            case "Blue":
                playerTokenImage = new ImageIcon("resources/A12Blue2.png");
                break;
            case "Yellow":
                playerTokenImage = new ImageIcon("resources/A12Yellow2.png");
                break;
            case "Pink":
                playerTokenImage = new ImageIcon("resources/A12Pink2.png");
                break;
            case "Purple":
                playerTokenImage = new ImageIcon("resources/A12Purple2.png");
                break;
            case "Black":
                playerTokenImage = new ImageIcon("resources/A12Black2.png");
                break;
        }
        return playerTokenImage;
    }

    /**
     * Formats the given time in seconds into a string representation.
     *
     * @param seconds The time in seconds
     * @return The formatted time string (e.g., "3m 25s")
     */
    public String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%dm %ds", minutes, remainingSeconds);
    }
}