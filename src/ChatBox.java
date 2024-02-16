import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatBox {
    ChatBox(){

    }
    public JLayeredPane MainChatBox(){

        JLayeredPane baseChatLayer = new JLayeredPane();
        baseChatLayer.setLayout(new FlowLayout());
        baseChatLayer.setPreferredSize(new Dimension(420,610));
        baseChatLayer.setBorder(new EmptyBorder(100,0,0,10));

        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(410,560));
        basePanel.setBackground(new Color(68,114,196));

        JPanel savedChatPanel = new JPanel();
        savedChatPanel.setPreferredSize(new Dimension(400, 550));
        savedChatPanel.setBackground(new Color(143,170,220));
        //savedChatPanel.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        JTextArea chatBox = new JTextArea("Chat");
        chatBox.setPreferredSize(new Dimension(325,50));
        chatBox.setBackground(Color.white);
        chatBox.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setPreferredSize(new Dimension(75,50));
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        basePanel.add(savedChatPanel);
        baseChatLayer.add(basePanel);
        baseChatLayer.add(chatBox);
        baseChatLayer.add(sendButton);



        return baseChatLayer;
    }

}
