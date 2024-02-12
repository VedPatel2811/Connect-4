import javax.swing.*;
import java.awt.*;

import static java.awt.Frame.NORMAL;

public class MenuBar {
    MenuBar(){
    }
    public void menuBar(JFrame myFrame){
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBackground(new Color(180,199,231));
        menuPanel.setBounds(0,0,1920,30);
        myFrame.add(menuPanel);

        JButton file = new JButton(" File |");
        myButton(file);

        JButton game = new JButton(" Game |");
        myButton(game);

        JButton network = new JButton(" Network |");
        myButton(network);

        JButton language = new JButton(" Language |");
        myButton(language);

        JButton help = new JButton(" Help");
        myButton(help);

        menuPanel.add(file);
        menuPanel.add(game);
        menuPanel.add(network);
        menuPanel.add(language);
        menuPanel.add(help);

        myFrame.add(menuPanel);
    }

    private void myButton(JButton myButton){
        myButton.setBorder(null);
        myButton.setFont(new Font("Calibri", NORMAL,20));
        myButton.setForeground(new Color(0,0,0));
        myButton.setBackground(new Color(180,199,231));
    }
}
