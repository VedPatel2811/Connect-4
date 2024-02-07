import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class Background extends JFrame{
    Background(){

    }
    public void CreateBackground (){

        MenuBar();
        CreateTitle();

        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setTitle("CONNECT 4");
        this.getContentPane().setBackground(new Color(143,170,220));


        ImageIcon image = new ImageIcon("A12logo.png");
        this.setIconImage(image.getImage());

    }

    public void CreateTitle(){
        JLabel title = new JLabel();
        title.setText("CONNECT 4");
        title.setBorder(BorderFactory.createEmptyBorder(35,0,5,0));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(53,90,155));
        title.setFont(new Font("Calibri", BOLD,60));
        this.add(title);
    }

    public void MenuBar(){
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBackground(new Color(180,199,231));
        menuPanel.setBounds(0,0,1920,30);
        this.add(menuPanel);

        JButton file = new JButton(" File |");
        file.setOpaque(false);
        file.setContentAreaFilled(false);
        file.setBorder(null);
        file.setFont(new Font("Calibri", NORMAL,20));
        file.setForeground(new Color(0,0,0));

        JButton game = new JButton(" Game |");
        game.setOpaque(false);
        game.setContentAreaFilled(false);
        game.setBorder(null);
        game.setFont(new Font("Calibri", NORMAL,20));
        game.setForeground(new Color(0,0,0));

        JButton network = new JButton(" Network |");
        network.setOpaque(false);
        network.setContentAreaFilled(false);
        network.setBorder(null);
        network.setFont(new Font("Calibri", NORMAL,20));
        network.setForeground(new Color(0,0,0));

        JButton language = new JButton(" Language |");
        language.setOpaque(false);
        language.setContentAreaFilled(false);
        language.setBorder(null);
        language.setFont(new Font("Calibri", NORMAL,20));
        language.setForeground(new Color(0,0,0));

        JButton help = new JButton(" Help");
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.setBorder(null);
        help.setFont(new Font("Calibri", NORMAL,20));
        help.setForeground(new Color(0,0,0));

        menuPanel.add(file);
        menuPanel.add(game);
        menuPanel.add(network);
        menuPanel.add(language);
        menuPanel.add(help);
    }
}
