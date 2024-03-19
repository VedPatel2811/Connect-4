import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * MenuBar class for creating a menu bar in a Connect-4 game UI.
 * This class is responsible for creating and managing the menu bar
 * displayed at the top of the game window. It includes menus for
 * file operations, game controls, network settings, language preferences,
 * and help options.
 */


public class MenuBar {

    /**
     * Constructor for MenuBar.
     */
    MenuBar(){
    }


    /**
     * Creates and returns a JMenuBar object with all necessary menus and items.
     * The menu bar includes "File", "Game", "Network", "Language", and "Help" menus,
     * each containing relevant menu items for the Connect-4 game.
     *
     * @return JMenuBar The menu bar with all menus and items added.
     */
    public JMenuBar Menu(){

        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu networkMenu = new JMenu("Network");
        JMenu languageMenu = new JMenu("Language");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem endGameItem = new JMenuItem("End Game");
        JMenuItem rulesItem = new JMenuItem("Rules");
        JMenuItem connectItem = new JMenuItem("Connect player");
        JMenuItem frenchItem = new JMenuItem("French");
        JMenuItem englishItem = new JMenuItem("English");
        JMenuItem updateItem = new JMenuItem("check update");
        JMenuItem infoItem = new JMenuItem("Info");


        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);
        gameMenu.add(endGameItem);
        gameMenu.add(rulesItem);
        networkMenu.add(connectItem);
        languageMenu.add(frenchItem);
        languageMenu.add(englishItem);
        helpMenu.add(updateItem);
        helpMenu.add(infoItem);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        gameMenu.setMnemonic(KeyEvent.VK_G);
        networkMenu.setMnemonic(KeyEvent.VK_N);
        languageMenu.setMnemonic(KeyEvent.VK_L);
        helpMenu.setMnemonic(KeyEvent.VK_H);

        jMenuBar.add(fileMenu);
        jMenuBar.add(gameMenu);
        jMenuBar.add(networkMenu);
        jMenuBar.add(languageMenu);
        jMenuBar.add(helpMenu);

        return jMenuBar;
    }
}
