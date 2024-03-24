import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * MenuBar class for creating a menu bar in a Connect-4 game UI.
 * This class is responsible for creating and managing the menu bar
 * displayed at the top of the game window. It includes menus for
 * file operations, game controls, network settings, language preferences,
 * and help options.
 */


public class MenuBar {

    private final GameInfo gameInfo;
    private ResourceBundle messages;
    private Locale currentLocale;

    private JMenu fileMenu;
    private JMenu gameMenu;
    private JMenu networkMenu;
    private JMenu languageMenu;
    private JMenu helpMenu;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenuItem exitItem;
    private JMenuItem endGameItem;
    private JMenuItem rulesItem;
    private JMenuItem connectItem;
    private JMenuItem frenchItem;
    private JMenuItem englishItem;
    private JMenuItem updateItem;
    private JMenuItem infoItem;
    /**
     * Constructor for MenuBar.
     */
    public MenuBar(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        currentLocale = Locale.getDefault(); // or set your default Locale
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        initializeMenus();
    }

    private void initializeMenus() {
        fileMenu = new JMenu();
        gameMenu = new JMenu();
        networkMenu = new JMenu();
        languageMenu = new JMenu();
        helpMenu = new JMenu();

        saveItem = new JMenuItem();
        loadItem = new JMenuItem();
        exitItem = new JMenuItem();
        endGameItem = new JMenuItem();
        rulesItem = new JMenuItem();
        connectItem = new JMenuItem();
        frenchItem = new JMenuItem();
        englishItem = new JMenuItem();
        updateItem = new JMenuItem();
        infoItem = new JMenuItem();

        englishItem.addActionListener(e -> {
            System.out.println("Switching to English");
            switchLanguage("en", "CA");
        });
        frenchItem.addActionListener(e -> {
            System.out.println("Switching to French");
            switchLanguage("fr", "CA");
        });

        updateTexts();
    }


    public JMenuBar createMenuBar() {
        // Assemble your JMenuBar and return it

            // Create a new JMenuBar
        JMenuBar menuBar = new JMenuBar();


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

        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        menuBar.add(networkMenu);
        menuBar.add(languageMenu);
        menuBar.add(helpMenu);
        // Return the assembled menu bar
        return menuBar;
    }


    public void switchLanguage(String languageCode, String countryCode) {
        // Update currentLocale, messages, and call updateTexts()
        currentLocale = new Locale(languageCode, countryCode);
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateTexts();
        gameInfo.updateText();
    }

    private void updateTexts() {
        // Update the texts of all menus and menu items
        fileMenu.setText(messages.getString("file"));
        gameMenu.setText(messages.getString("game"));
        networkMenu.setText(messages.getString("network"));
        languageMenu.setText(messages.getString("language"));
        helpMenu.setText(messages.getString("help"));

        saveItem.setText(messages.getString("save"));
        loadItem.setText(messages.getString("load"));
        exitItem.setText(messages.getString("exit"));
        endGameItem.setText(messages.getString("endGame"));
        rulesItem.setText(messages.getString("rules"));
        connectItem.setText(messages.getString("connectPlayer"));
        frenchItem.setText(messages.getString("french"));
        englishItem.setText(messages.getString("english"));
        updateItem.setText(messages.getString("checkForUpdate"));
        infoItem.setText(messages.getString("info"));
    }


    /**
     * Creates and returns a JMenuBar object with all necessary menus and items.
     * The menu bar includes "File", "Game", "Network", "Language", and "Help" menus,
     * each containing relevant menu items for the Connect-4 game.
     *
     * @return JMenuBar The menu bar with all menus and items added.
     */

}