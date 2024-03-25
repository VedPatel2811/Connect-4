import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

/**
 * SplashScreen class represents a splash screen for the Connect 4 game application.
 * It displays the project title and developer names for a specified duration.
 */
public class SplashScreen extends JWindow {

    /**
     * Width
     */
    private static final int SPLASH_WIDTH = 500;
    /**
     * Height
     */
    private static final int SPLASH_HEIGHT = 300;
    /**
     * Display splash screen for 3 sec
     */
    private static final int DISPLAY_TIME = 3000;

    /**
     * Displays the splash screen with the project title and developer names.
     */
    public void showSplashScreen() {
        JPanel splashPanel = new JPanel() {
            /**
             * Create the splash screen panel
             * @param g the <code>Graphics</code> object to protect
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(143, 170, 220)); // Set background color
                g.fillRect(0, 0, getWidth(), getHeight()); // Fill background
                g.setColor(new Color(53,90,155)); // Set text color
                g.setFont(new Font("Calibri", BOLD,90)); // Set font
                g.drawString("Connect 4", 60, 125); // Draw project title
                g.setFont(new Font("Calibri", BOLD, 40)); // Set font
                g.drawString("Ved Patel and Steve", 90, 200); // Draw developer names
            }
        };
        splashPanel.setPreferredSize(new Dimension(SPLASH_WIDTH, SPLASH_HEIGHT));

        // Center the splash screen on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - SPLASH_WIDTH) / 2;
        int y = (screenSize.height - SPLASH_HEIGHT) / 2;
        setBounds(x, y, SPLASH_WIDTH, SPLASH_HEIGHT);

        // Add the splash panel to the window
        getContentPane().add(splashPanel);
        setVisible(true);

        // Close the splash screen after a delay
        try {
            Thread.sleep(DISPLAY_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisible(false);
        dispose();
    }
}
