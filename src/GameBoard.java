import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Represents the game board panel where the Connect Four game is displayed and played.
 * This panel contains the grid layout for the game board and handles UI updates based on the game model.
 */
public class GameBoard extends JPanel implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * The game model containing the logic for the Connect Four game.
     */
    private final transient Model model;

    /**
     * The base panel of the game board.
     */
    private final JPanel basePanel; // Define basePanel here

    /**
     * The icon representing Player 1's game piece.
     */
    private final ImageIcon player1Icon; // Icon for Player 1

    /**
     * The icon representing Player 2's game piece.
     */
    private final ImageIcon player2Icon; // Icon for Player 2

    /**
     * Constructs a GameBoard object with the specified game model and player tokens.
     *
     * @param model        The game model containing the logic for the Connect Four game
     * @param player1Token The token representing Player 1's game piece
     * @param player2Token The token representing Player 2's game piece
     */
    GameBoard(Model model,String player1Token, String player2Token) {
        this.model = model;
        this.basePanel = MainGameBoard(); // Initialize basePanel
        this.player1Icon = new ImageIcon(imageCases(player1Token).getImage()); // Load image for Player 1
        this.player2Icon = new ImageIcon(imageCases(player2Token).getImage()); // Load image for Player 2

    }



    /**
     * Creates and returns the main game board panel with a grid layout.
     *
     * @return The main game board panel
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
            imageLabel.setIcon(new ImageIcon("resources/A12Blank.png")); // Initially set to "A12Blank.png"
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setVerticalAlignment(SwingConstants.CENTER);
            gameCoins.add(imageLabel, BorderLayout.CENTER);


            basePanel.add(gameCoins);
        }

        return basePanel;
    }

    /**
     * Retrieves the base panel containing the game board.
     * @return The base panel containing the game board
     */
    public JPanel getBasePanel() {
        return basePanel;
    }

    /**
     * Adds an ActionListener to all buttons in the game board panel.
     * @param listener listener The ActionListener to be added
     */
    public void addChipDropListener(ActionListener listener) {
        // Add ActionListener to buttons
        Component[] components = basePanel.getComponents();
        for (Component component : components) {
            ((JButton) component).addActionListener(listener);
        }
    }

    /**
     * Retrieves the column index corresponding to the specified button.
     * @param button The button whose column index is to be determined
     * @return The column index of the button, or -1 if not found
     */
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

    /**
     * Updates the game board UI based on the model.
     */
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

    /**
     * Sets the icon at the specified row and column on the game board.
     * @param row The row index
     * @param col The column index
     * @param icon The icon to be set
     */
    private void setIconAt(int row, int col, ImageIcon icon) {
        JButton button = (JButton) basePanel.getComponent(row * 7 + col);
        JLabel label = (JLabel) button.getComponent(0);
        label.setIcon(icon);
    }

    /**
     * Displays a message indicating the winner of the game.
     * @param player The name of the winning player
     */
    public void showWinner(String player) {
        String message = player + " Wins the game!";
        JOptionPane.showMessageDialog(null, message, "Winner", JOptionPane.INFORMATION_MESSAGE);
        resetBoard();
    }

    /**
     * Displays a message indicating that the game ended in a draw.
     */
    public void showDraw() {
        String message = "The Game is Draw!";
        JOptionPane.showMessageDialog(null, message, "Draw", JOptionPane.INFORMATION_MESSAGE);
        resetBoard();
    }

    /**
     * Resets the game board by clearing all icons and resetting the game model.
     */
    public void resetBoard() {
        model.resetBoard();
        for (Component component : basePanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button;
                button = (JButton) component;
                JLabel label = (JLabel) button.getComponent(0);
                label.setIcon(new ImageIcon("resources/A12Blank.png"));
            }
        }
    }

    /**
     * Generates an image icon based on the provided player token.
     * @param playerToken The player's token
     * @return The corresponding image icon
     */
    private ImageIcon imageCases(String playerToken){
        ImageIcon playerTokenImage = null;
        switch (playerToken){
            case "Red":
                playerTokenImage = new ImageIcon("resources/A12Red.png");
                break;
            case "Orange":
                playerTokenImage = new ImageIcon("resources/A12Orange.png");
                break;
            case "Green":
                playerTokenImage = new ImageIcon("resources/A12Green.png");
                break;
            case "Blue":
                playerTokenImage = new ImageIcon("resources/A12Blue.png");
                break;
            case "Yellow":
                playerTokenImage = new ImageIcon("resources/A12Yellow.png");
                break;
            case "Pink":
                playerTokenImage = new ImageIcon("resources/A12Pink.png");
                break;
            case "Purple":
                playerTokenImage = new ImageIcon("resources/A12Purple.png");
                break;
            case "Black":
                playerTokenImage = new ImageIcon("resources/A12Black.png");
                break;
            default:

                break;
        }
        return playerTokenImage;
    }
}