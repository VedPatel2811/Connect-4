import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

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
        Board();

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
    
    public void Board(){
    	int row = 6;
    	int col = 7;
    	JPanel gameBoardPanel = new JPanel();
    	gameBoardPanel.setLayout(new GridLayout(row, col));
    	
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    	        JPanel slotPanel = new JPanel();
    	        slotPanel.setBorder(new LineBorder(Color.BLACK)); 
    	        gameBoardPanel.add(slotPanel);
    		}
    	}
    	
        this.add(gameBoardPanel, BorderLayout.CENTER);

    	
    }
}
