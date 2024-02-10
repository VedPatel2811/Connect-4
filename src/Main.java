import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame();

        MenuBar MyBar = new MenuBar();
        MyBar.menuBar(myFrame);

        Header myHeader = new Header();
        myHeader.header(myFrame);


        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,400);
        myFrame.setTitle("CONNECT 4");
        myFrame.getContentPane().setBackground(new Color(143,170,220));
        ImageIcon image = new ImageIcon("A12logo.png");
        myFrame.setIconImage(image.getImage());
        myFrame.setVisible(true);


    }
}