import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

/**
 * Header class for creating a header label for a Connect-4 game UI.
 * This class is responsible for creating and customizing the header
 * label which displays the game's title.
 */

public class Header {

    /**
     * Constructor for Header.
     */
    Header(){
    }

    /**
     * Creates and returns a JLabel object configured as the header for the Connect-4 game.
     * The method sets the text, border, alignment, color, and font of the JLabel to
     * display the game's title appropriately.
     *
     * @return JLabel The customized header label for the Connect-4 game.
     */
    public JLabel ConnectHeader(){
        JLabel title = new JLabel();
        title.setText("CONNECT 4");
        title.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(53,90,155));
        title.setFont(new Font("Calibri", BOLD,90));
        return title;
    }
}