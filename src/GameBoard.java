import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GameBoard class for creating the main game board for a Connect-4 game UI.
 * This class is responsible for setting up the game grid, which includes
 * the layout, background, borders, and individual game cells.
 */

public class GameBoard {
    private final Model model;
    private final JPanel basePanel; // Define basePanel here
    private final ImageIcon player1Icon; // Icon for Player 1
    private final ImageIcon player2Icon; // Icon for Player 2

    /**
     * Constructor for GameBoard.
     * It calls the MainGameBoard method to initialize the game board.
     */
    GameBoard(Model model,String player1Token, String player2Token) {
        this.model = model;
        this.basePanel = MainGameBoard(); // Initialize basePanel
        this.player1Icon = new ImageIcon(imageCases(player1Token).getImage()); // Load image for Player 1
        this.player2Icon = new ImageIcon(imageCases(player2Token).getImage()); // Load image for Player 2
    }
    /**
     * Creates and returns a JPanel object configured as the main game board for Connect-4.
     * The method sets up a grid layout for the game, customizes its appearance,
     * and populates it with buttons representing the game coins.
     *
     * @return JPanel The main game board panel with all game cells added.
     */
    public JPanel MainGameBoard() {
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new GridLayout(6, 7));

        basePanel.setPreferredSize(new Dimension(1000, 800));
        basePanel.setBackground(new Color(68, 114, 196));
        basePanel.setBorder(new EmptyBorder(0, 25, 0, 0));
        basePanel.setBorder(BorderFactory.createLineBorder(new Color(53, 90, 156), 2));

        for (int i = 0; i < 42; i++) {
            JButton gameCoins = new JButton();
            gameCoins.setLayout(new BorderLayout());
            gameCoins.setBackground(new Color(68, 114, 196));
            gameCoins.setBorder(null);
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(new ImageIcon("A12Blank.png")); // Initially set to "A12Blank.png"
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setVerticalAlignment(SwingConstants.CENTER);
            gameCoins.add(imageLabel, BorderLayout.CENTER);


            basePanel.add(gameCoins);
        }

        return basePanel;
    }

    public JPanel getBasePanel() {
        return basePanel;
    }

    public void addChipDropListener(ActionListener listener) {
        // Add ActionListener to buttons
        Component[] components = basePanel.getComponents();
        for (Component component : components) {
            ((JButton) component).addActionListener(listener);
        }
    }

    public int getColumn(JButton button) {
        // Determine column index from button's position
        Component[] components = basePanel.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i].equals(button)) {
                return i % 7;
            }
        }
        return -1; // Not found
    }

    public void updateBoard() {
        // Update UI based on model
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                int chip = model.getChipAt(row, col);
                if (chip == 1) {
                    setIconAt(row, col, player1Icon); // Player 1's chip
                } else if (chip == 2) {
                    setIconAt(row, col, player2Icon); // Player 2's chip
                }
            }
        }
    }

    private void setIconAt(int row, int col, ImageIcon icon) {
        JButton button = (JButton) basePanel.getComponent(row * 7 + col);
        JLabel label = (JLabel) button.getComponent(0);
        label.setIcon(icon);
    }

    public void showWinner(String player) {
        String message = player + " Wins the game!";
        JOptionPane.showMessageDialog(null, message, "Winner", JOptionPane.INFORMATION_MESSAGE);
        resetBoard();
    }

    public void showDraw() {
        String message = "The Game is Draw!";
        JOptionPane.showMessageDialog(null, message, "Draw", JOptionPane.INFORMATION_MESSAGE);
        resetBoard();
    }

    public void resetBoard() {
        model.resetBoard();
        for (Component component : basePanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                JLabel label = (JLabel) button.getComponent(0);
                label.setIcon(new ImageIcon("A12Blank.png"));
            }
        }
    }
    private ImageIcon imageCases(String playerToken){
        ImageIcon playerTokenImage = null;
        switch (playerToken){
            case "Red":
                playerTokenImage = new ImageIcon("A12Red.png");
                break;
            case "Orange":
                playerTokenImage = new ImageIcon("A12Orange.png");
                break;
            case "Green":
                playerTokenImage = new ImageIcon("A12Green.png");
                break;
            case "Blue":
                playerTokenImage = new ImageIcon("A12Blue.png");
                break;
            case "Yellow":
                playerTokenImage = new ImageIcon("A12Yellow.png");
                break;
            case "Pink":
                playerTokenImage = new ImageIcon("A12Pink.png");
                break;
            case "Purple":
                playerTokenImage = new ImageIcon("A12Purple.png");
                break;
            case "Black":
                playerTokenImage = new ImageIcon("A12Black.png");
                break;
        }
        return playerTokenImage;
    }
}