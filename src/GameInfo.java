import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
    /**
     * Constructor for GameInfo.
     */

    public GameInfo() {

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

        ImageIcon myImage = new ImageIcon("A12Red2.png");

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(myImage);

        JLabel player1Label = new JLabel();
        player1Label.setIcon(myImage);

        JLabel nameLabel = new JLabel("Steve");
        nameLabel.setForeground(new Color(124, 150, 199));
        nameLabel.setFont(new Font("Calibri", Font.BOLD, 50));

        JLabel winLabel = new JLabel("0 Win");
        winLabel.setForeground(new Color(124, 150, 199));
        winLabel.setFont(new Font("Calibri", Font.BOLD, 35));

        JLabel turnLabel = new JLabel("Your Turn");
        turnLabel.setForeground(color);
        turnLabel.setFont(new Font("Calibri", Font.BOLD, 30));

        player1.add(imageLabel);
        player1.add(nameLabel);
        player1.add(winLabel);
        player1.add(turnLabel);
        player1TurnLabel = turnLabel;

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
        ImageIcon myImage = new ImageIcon("A12Black2.png");

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(myImage);

        JLabel player1Label = new JLabel();
        player1Label.setIcon(myImage);

        JLabel nameLabel = new JLabel("Ved");
        nameLabel.setVerticalTextPosition(JLabel.BOTTOM);
        nameLabel.setForeground(new Color(124, 150, 199));
        nameLabel.setFont(new Font("Calibri", Font.BOLD, 50));

        JLabel winLabel = new JLabel("0 Win");
        winLabel.setForeground(new Color(124, 150, 199));
        winLabel.setFont(new Font("Calibri", Font.BOLD, 35));

        JLabel turnLabel = new JLabel("Your Turn");
        turnLabel.setForeground(color);
        turnLabel.setFont(new Font("Calibri", Font.BOLD, 30));

        player2.add(imageLabel);
        player2.add(nameLabel);
        player2.add(winLabel);
        player2.add(turnLabel);
        player2TurnLabel = turnLabel;

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

        JLabel round = new JLabel();
        round.setText("Round 1.");
        round.setHorizontalAlignment(JLabel.LEFT);
        round.setForeground(new Color(124, 150, 199));
        round.setFont(new Font("Calibri", Font.BOLD, 40));


        JLabel instruction = new JLabel();
        instruction.setText("Click on a column to make your move.");
        instruction.setForeground(new Color(124, 150, 199));
        instruction.setFont(new Font("Calibri", Font.BOLD, 20));
        instruction.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel timer1 = new JLabel();
        timer1.setText("Timer: 22s");
        timer1.setForeground(new Color(124, 150, 199));
        timer1.setFont(new Font("Calibri", Font.BOLD, 40));
        timer1.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel timer2 = new JLabel();
        timer2.setText("Game time: 3m 11s");
        timer2.setForeground(new Color(124, 150, 199));
        timer2.setFont(new Font("Calibri", Font.BOLD, 30));
        timer2.setHorizontalAlignment(SwingConstants.LEFT);


        timeInfo.add(round);
        timeInfo.add(instruction);
        timeInfo.add(Box.createRigidArea(new Dimension(350,50)));
        timeInfo.add(timer1);
        timeInfo.add(timer2);

        return timeInfo;
    }

    public JLabel getPlayer1TurnLabel() {
        return player1TurnLabel;
    }
    public JLabel getPlayer2TurnLabel() {
        return player2TurnLabel;
    }

}
