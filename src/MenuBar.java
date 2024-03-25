import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
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
    public JMenuItem saveItem;
    public JMenuItem loadItem;
    public JMenuItem exitItem;
    public JMenuItem resetGame;
    public JMenuItem rulesItem;
    public JMenuItem connectItem;
    public JMenuItem frenchItem;
    public JMenuItem englishItem;
    public JMenuItem updateItem;
    public JMenuItem infoItem;

    private ImageIcon saveIcon;
    private ImageIcon loadIcon;
    private ImageIcon exitIcon;
    private ImageIcon engIcon;
    private ImageIcon frIcon;


    /**
     *
     * @param gameInfo
     */
    public MenuBar(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        currentLocale = Locale.getDefault(); // or set your default Locale
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

        saveIcon = new ImageIcon("piciconabt.gif");
        loadIcon = new ImageIcon("piciconload.gif");
        exitIcon = new ImageIcon("piciconext.gif");
        engIcon = new ImageIcon("piciconeng.gif");
        frIcon = new ImageIcon("piciconfra.gif");

        initializeMenus();
    }

    /**
     *
     */
    private void initializeMenus() {
        fileMenu = new JMenu();
        gameMenu = new JMenu();
        networkMenu = new JMenu();
        languageMenu = new JMenu();
        helpMenu = new JMenu();

        saveItem = new JMenuItem();
        loadItem = new JMenuItem();
        exitItem = new JMenuItem();
        resetGame = new JMenuItem();
        rulesItem = new JMenuItem();
        connectItem = new JMenuItem();
        frenchItem = new JMenuItem();
        englishItem = new JMenuItem();
        updateItem = new JMenuItem();
        infoItem = new JMenuItem();

        saveItem = new JMenuItem(messages.getString("save"), saveIcon);
        loadItem = new JMenuItem(messages.getString("load"), loadIcon);
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
     *
     * @return
     */
    public JMenuBar createMenuBar() {
        // Assemble your JMenuBar and return it

        // Create a new JMenuBar
        JMenuBar menuBar = new JMenuBar();


        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);

        gameMenu.add(resetGame);
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

    /**
     *
     * @param languageCode
     * @param countryCode
     */
    public void switchLanguage(String languageCode, String countryCode) {
        // Update currentLocale, messages, and call updateTexts()
        currentLocale = new Locale(languageCode, countryCode);
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        updateTexts();
        gameInfo.updateText();
    }

    /**
     *
     */
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
        resetGame.setText(messages.getString("resetGame"));
        rulesItem.setText(messages.getString("rules"));
        connectItem.setText(messages.getString("connectPlayer"));
        frenchItem.setText(messages.getString("french"));
        englishItem.setText(messages.getString("english"));
        updateItem.setText(messages.getString("checkForUpdate"));
        infoItem.setText(messages.getString("info"));
    }
}