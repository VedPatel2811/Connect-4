import javax.swing.*;
import java.awt.*;

public class GameInfo extends JPanel {

    public GameInfo() {

    }

    public void GameInfoPanel(JFrame myFrame){

        JPanel basePanel = BasePanel();
        JPanel player1 = Player1();
        JPanel player2 = Player2();

        JLayeredPane mainLayer = new JLayeredPane();
        mainLayer.setBounds(10,50, 425, 615);
        mainLayer.add(player1);
        mainLayer.add(player2);
        mainLayer.add(basePanel);

        myFrame.add(mainLayer);
    }
    public JPanel BasePanel(){
        JPanel basePanel = new JPanel();
        //basePanel.setOpaque(true);
        basePanel.setBackground(new Color(68,114,196));
        basePanel.setBounds(10,50, 425, 610);
        return basePanel;
    }
    public JPanel Player1(){
        JPanel player1 = new JPanel();
        //player1.setOpaque(true);
        player1.setBackground(new Color(32,56,100));
        player1.setBounds(25,65, 193, 250);
        return player1;
    }
    public JPanel Player2(){
        JPanel player2 = new JPanel();
        //player2.setOpaque(true);
        player2.setBackground(new Color(32,56,100));
        player2.setBounds(225,65, 193, 250);
        return player2;
    }

}
