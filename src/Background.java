import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class Background extends JFrame{
    Background(){

    }
    public void CreateBackground (){

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
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(53,90,155));
        title.setFont(new Font("Calibri", BOLD,58));
        this.add(title);
    }

    public void titleBar(){
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(180,199,231));
    }
}
