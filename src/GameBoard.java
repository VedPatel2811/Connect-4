import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class SlotPanel extends JPanel {
    private Color circleColor = Color.WHITE; // Default color

    public SlotPanel() {
        // Make panel transparent
        setOpaque(false);
    }

    public void setCircleColor(Color color) {
        circleColor = color;
        repaint(); // Repaint this panel with the new color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        // Anti-aliasing for smoother circles
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw the circle with the specified color
        g2d.setColor(Color.WHITE);
        //g2d.setColor(circleColor);
        // The circle will be as large as the panel minus the border
        int padding = 5;
        int diameter = Math.min(getWidth(), getHeight()) - padding * 2;
       
        g2d.fillOval(padding, padding, diameter, diameter);
        g2d.dispose();
        //g2d.fill(new Ellipse2D.Double(2, 2, getWidth() - 4, getHeight() - 4));
        //g2d.dispose();
    }
}

public class GameBoard {
    private int row = 6;
    private int col = 7;
    private JPanel gameBoardPanel;
    private JPanel containerPanel;
    private Color darkBlue = new Color(21, 101, 192);
    private Color panelBackground = new Color(41, 128, 185); // This is the darker layer behind the slots
    
    GameBoard(JFrame myFrame) {
        Board(myFrame);
    }

    public void Board(JFrame myFrame) {
    	JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBackground(panelBackground); // Set the background to the darker color
        containerPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100)); // Top, left, bottom, 
       
        gameBoardPanel = new JPanel();
        gameBoardPanel.setLayout(new GridLayout(row, col));
        gameBoardPanel.setBackground(darkBlue); // Set the background to dark blue

        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                SlotPanel slotPanel = new SlotPanel();
                // The preferred size should be large enough to visually contain the circle
                slotPanel.setPreferredSize(new Dimension(60, 60));
                gameBoardPanel.add(slotPanel);
            }
        }
        
        containerPanel.add(gameBoardPanel, BorderLayout.CENTER);

        myFrame.add(gameBoardPanel, BorderLayout.CENTER);
    }
}