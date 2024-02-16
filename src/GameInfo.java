import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameInfo extends JPanel {

    public GameInfo() {

    }

    public JLayeredPane GameInfoPanel(){
        JLayeredPane baseLayer = new JLayeredPane();
        JPanel basePanel = new JPanel();
        baseLayer.setLayout(new FlowLayout());

        baseLayer.setPreferredSize(new Dimension(410, 610));
        basePanel.setPreferredSize(new Dimension(400, 600));

        baseLayer.setBorder(new EmptyBorder(100,0,0,0));

        basePanel.setBackground(new Color(68,114,196));

        JPanel player1 = new JPanel();
        player1.setBackground(new Color(32,56,100));
        player1.setPreferredSize(new Dimension(190,200));

        JPanel player2 = new JPanel();
        player2.setBackground(new Color(32,56,100));
        player2.setPreferredSize(new Dimension(190,200));

        JPanel timeInfo = new JPanel();
        timeInfo.setBackground(new Color(32,56,100));
        timeInfo.setPreferredSize(new Dimension(380, 280));


        basePanel.add(player1);
        basePanel.add(player2);
        basePanel.add(timeInfo);

        baseLayer.add(basePanel);
        //myFrame.add(baseLayer,BorderLayout.WEST);
        return baseLayer;
    }


}
