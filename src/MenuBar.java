import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar {
    MenuBar(){
    }
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




        //myFrame.setJMenuBar(jMenuBar);
        return jMenuBar;
    }
}
