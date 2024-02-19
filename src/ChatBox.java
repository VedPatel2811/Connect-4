import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * ChatBox class is part of the Connect-4 game UI, dedicated to providing a chat interface.
 * This class allows players to view messages and send new ones during the game.
 * It uses a JLayeredPane to arrange the chat components.
 */

public class ChatBox {

    /**
     * Constructor for ChatBox.
     */
    ChatBox(){

    }

    /**
     * Creates and returns the main chat box as a JLayeredPane.
     * This chat box includes areas for displaying saved chat messages and for typing new messages,
     * along with a send button.
     *
     * @return JLayeredPane The main layered pane containing chat components.
     */
    public JLayeredPane MainChatBox(){

        JLayeredPane baseChatLayer = new JLayeredPane();
        baseChatLayer.setLayout(new FlowLayout());
        baseChatLayer.setPreferredSize(new Dimension(420,620));
        baseChatLayer.setBorder(new EmptyBorder(0,25,0,0));

        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(400,600));
        basePanel.setBackground(new Color(68,114,196));

        JPanel savedChatPanel = new JPanel();
        savedChatPanel.setPreferredSize(new Dimension(385, 535));
        savedChatPanel.setBackground(new Color(143,170,220));

        JLabel textArea = new JLabel();
        textArea.setText("<html>Steve had played column 3. <br> Ved had played column 4.</html>");
        savedChatPanel.add(textArea);

        JTextArea chatBox = new JTextArea("Chat");
        chatBox.setPreferredSize(new Dimension(305,50));
        chatBox.setBackground(Color.white);
        chatBox.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setPreferredSize(new Dimension(80,50));
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        basePanel.add(savedChatPanel);
        basePanel.add(chatBox);
        basePanel.add(sendButton);

        baseChatLayer.add(basePanel);

        return baseChatLayer;
    }

}
