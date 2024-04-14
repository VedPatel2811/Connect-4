import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Represents the menu bar for the Connect Four game application.
 * This class handles the creation of menu items, switching languages, and updating text based on the current locale.
 */
public class MenuBar {

    /**
     * The game information object.
     */
    private final GameInfo gameInfo;

    /**
     * The resource bundle for localized messages.
     */
    private ResourceBundle messages;

    /**
     * The current locale for language settings.
     */
    private Locale currentLocale;

    /**
     * The file menu.
     */
    private JMenu fileMenu;

    /**
     * The game menu.
     */
    private JMenu gameMenu;

    /**
     * The network menu.
     */
    private JMenu networkMenu;

    /**
     * The language menu.
     */
    private JMenu languageMenu;

    /**
     * The help menu.
     */
    private JMenu helpMenu;

    /**
     * The menu item for exiting.
     */
    public JMenuItem exitItem;

    /**
     * The menu item for resetting the game.
     */
    public JMenuItem resetGame;

    /**
     * The menu item for viewing rules.
     */
    public JMenuItem rulesItem;

    /**
     * The menu item for host a network.
     */
    public JMenuItem hostItem;

    /**
     * The menu item for join a network.
     */
    public JMenuItem connectItem;

    /**
     * The menu item for disconnect a network.
     */
    public JMenuItem disconnectItem;

    /**
     * The menu item for selecting French language.
     */
    public JMenuItem frenchItem;

    /**
     * The menu item for selecting English language.
     */
    public JMenuItem englishItem;

    /**
     * The menu item for updating.
     */
    public JMenuItem updateItem;

    /**
     * The menu item for viewing information.
     */
    public JMenuItem infoItem;

    /**
     * The icon for the exit menu item.
     */
    private final ImageIcon exitIcon;

    /**
     * The icon for the English language menu item.
     */
    private final ImageIcon engIcon;

    /**
     * The icon for the French language menu item.
     */
    private final ImageIcon frIcon;



    /**
     * Constructs a MenuBar object with the specified game information.
     *
     * @param gameInfo The game information
     */
    public MenuBar(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        currentLocale = Locale.getDefault(); // or set your default Locale
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        exitIcon = new ImageIcon("resources/piciconext.gif");
        engIcon = new ImageIcon("resources/piciconeng.gif");
        frIcon = new ImageIcon("resources/piciconfra.gif");

        initializeMenus();
    }

    /**
     * Initializes the menus and menu items.
     */
    private void initializeMenus() {
        fileMenu = new JMenu();
        gameMenu = new JMenu();
        networkMenu = new JMenu();
        languageMenu = new JMenu();
        helpMenu = new JMenu();
        exitItem = new JMenuItem();
        resetGame = new JMenuItem();
        rulesItem = new JMenuItem();
        hostItem = new JMenuItem();
        connectItem=new JMenuItem();
        disconnectItem=new JMenuItem();
        frenchItem = new JMenuItem();
        englishItem = new JMenuItem();
        updateItem = new JMenuItem();
        infoItem = new JMenuItem();

        exitItem = new JMenuItem(messages.getString("exit"), exitIcon);

        frenchItem = new JMenuItem(messages.getString("french"), frIcon);
        englishItem = new JMenuItem(messages.getString("english"), engIcon);

        englishItem.addActionListener(e -> {
            switchLanguage("en", "CA");
            gameInfo.switchLanguage("en", "CA");
        });
        frenchItem.addActionListener(e -> {
            switchLanguage("fr", "CA");
            gameInfo.switchLanguage("fr", "CA");
        });

        updateTexts();
    }

    /**
     * Creates and returns the menu bar.
     *
     * @return The created menu bar
     */
    public JMenuBar createMenuBar() {
        // Assemble your JMenuBar and return it

        // Create a new JMenuBar
        JMenuBar menuBar = new JMenuBar();
        fileMenu.add(exitItem);

        gameMenu.add(resetGame);
        gameMenu.add(rulesItem);

        networkMenu.add(hostItem);
        networkMenu.add(connectItem);
        networkMenu.add(disconnectItem);

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

    /**
     * Switches the language of the application.
     *
     * @param languageCode The language code
     * @param countryCode  The country code
     */
    public void switchLanguage(String languageCode, String countryCode) {
        // Update currentLocale, messages, and call updateTexts()
        currentLocale = new Locale.Builder().setLanguage(languageCode).setRegion(countryCode).build();
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateTexts();
        gameInfo.updateText();
    }

    /**
     * Updates the texts of all menus and menu items based on the current locale.
     */
    private void updateTexts() {
        // Update the texts of all menus and menu items
        fileMenu.setText(messages.getString("file"));
        gameMenu.setText(messages.getString("game"));
        networkMenu.setText(messages.getString("network"));
        languageMenu.setText(messages.getString("language"));
        helpMenu.setText(messages.getString("help"));
        exitItem.setText(messages.getString("exit"));
        resetGame.setText(messages.getString("resetGame"));
        rulesItem.setText(messages.getString("rules"));

        hostItem.setText(messages.getString("host"));
        connectItem.setText(messages.getString("connect"));
        disconnectItem.setText(messages.getString("disconnect"));

        frenchItem.setText(messages.getString("french"));
        englishItem.setText(messages.getString("english"));
        updateItem.setText(messages.getString("checkForUpdate"));
        infoItem.setText(messages.getString("info"));
    }
}