import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameInfo extends JPanel {

    public GameInfo() {

    }

    public JLayeredPane GameInfoPanel(){
        JLayeredPane baseLayer = new JLayeredPane();
        JPanel basePanel = BasePanel();

        baseLayer.setLayout(new FlowLayout());
        baseLayer.setPreferredSize(new Dimension(455, 610));
        baseLayer.setBorder(new EmptyBorder(100,0,0,0));

        baseLayer.add(basePanel);
        return baseLayer;
    }
    private JPanel BasePanel(){
        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(420, 560));
        basePanel.setBackground(new Color(68,114,196));
        basePanel.setBorder(new EmptyBorder(20,20,20,20));

        JPanel player1 = Player1();
        JPanel player2 = Player2();
        JPanel timeInfo = TimeInfo();

        basePanel.add(player1);
        basePanel.add(player2);
        basePanel.add(timeInfo);
        return basePanel;
    }
    private JPanel Player1(){
        JPanel player1 = new JPanel();
        player1.setBackground(new Color(32,56,100));
        player1.setPreferredSize(new Dimension(185,250));

        return player1;
    }

    private JPanel Player2(){
        JPanel player2 = new JPanel();
        player2.setBackground(new Color(32,56,100));
        player2.setPreferredSize(new Dimension(185,250));
        return player2;
    }

    private JPanel TimeInfo(){
        JPanel timeInfo = new JPanel();
        timeInfo.setBackground(new Color(32,56,100));
        timeInfo.setPreferredSize(new Dimension(375, 250));
        return timeInfo;
    }



}
