import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MenuBar myBar = new MenuBar();
        Header connect4 = new Header();
        GameInfo gameInfo = new GameInfo();
        GameBoard myBoard = new GameBoard();
        ChatBox myChat = new ChatBox();

        JFrame myFrame = new JFrame();
        myFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(143,170,220));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new Color(143,170,220));


        bottomPanel.add(gameInfo.GameInfoPanel());
        bottomPanel.add(myBoard.MainGameBoard());
        bottomPanel.add(myChat.MainChatBox());
        //bottomPanel.add(emptyPanel,BorderLayout.SOUTH);


        topPanel.add(connect4.ConnectHeader());
        topPanel.add(myBar.Menu(),BorderLayout.NORTH);
        myFrame.add(topPanel, BorderLayout.NORTH);
        myFrame.add(bottomPanel);






        myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
        myFrame.setPreferredSize(new Dimension(1920,1080));
        myFrame.setTitle("CONNECT 4");
        myFrame.getContentPane().setBackground(new Color(143,170,220));
        ImageIcon image = new ImageIcon("A12logo.png");
        myFrame.setIconImage(image.getImage());
        myFrame.pack();
        myFrame.setVisible(true);
    }
}