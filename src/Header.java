import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class Header {
    Header(){
    }

    public void header(JFrame myFrame){
        JLabel title = new JLabel();
        title.setText("CONNECT 4");
        title.setBorder(BorderFactory.createEmptyBorder(35,0,5,0));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(new Color(53,90,155));
        title.setFont(new Font("Calibri", BOLD,80));
        myFrame.add(title);
    }
}
