import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * GameBoard class for creating the main game board for a Connect-4 game UI.
 * This class is responsible for setting up the game grid, which includes
 * the layout, background, borders, and individual game cells.
 */

public class GameBoard {

    /**
     * Constructor for GameBoard.
     * It calls the MainGameBoard method to initialize the game board.
     */
    GameBoard(){
        MainGameBoard();
    }

    /**
     * Creates and returns a JPanel object configured as the main game board for Connect-4.
     * The method sets up a grid layout for the game, customizes its appearance,
     * and populates it with buttons representing the game coins.
     *
     * @return JPanel The main game board panel with all game cells added.
     */
    public JPanel MainGameBoard(){
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new GridLayout(6,7));

        basePanel.setPreferredSize(new Dimension(1000, 800));
        basePanel.setBackground(new Color(68,114,196));
        basePanel.setBorder(new EmptyBorder(0,25,0,0));
        basePanel.setBorder(BorderFactory.createLineBorder(new Color(53,90,156),2));



        for (int i = 0; i < 42 ; i++){
            JButton gameCoins = new JButton();
            gameCoins.setLayout(new BorderLayout());
            gameCoins.setBackground(new Color(68,114,196));
            gameCoins.setBorder(null);
            ImageIcon image = new ImageIcon("A12Blank.png");
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(image);
            gameCoins.add(imageLabel, BorderLayout.CENTER);

            basePanel.add(gameCoins);
        }

        return basePanel;
    }

}
