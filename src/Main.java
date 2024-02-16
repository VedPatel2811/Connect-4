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




        myFrame.add(gameInfo.GameInfoPanel(), BorderLayout.WEST);
        myFrame.add(myBoard.MainGameBoard(),BorderLayout.CENTER);
        myFrame.add(myChat.MainChatBox(), BorderLayout.EAST);
        myFrame.add(connect4.ConnectHeader());
        myFrame.add(myBar.Menu(),BorderLayout.NORTH);




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