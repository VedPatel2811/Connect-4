import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * A class representing a chat box GUI component.
 */
public class ChatBox {

    /**
     * Constructs a new ChatBox instance.
     */
    ChatBox(){

    }

    /**
     * Constructs and returns the main chat box component.
     * @return The main chat box component.
     */
    public JLayeredPane MainChatBox(){
        // Create a layered pane to hold different components
        JLayeredPane baseChatLayer = new JLayeredPane();
        baseChatLayer.setLayout(new FlowLayout());
        baseChatLayer.setPreferredSize(new Dimension(420,620));
        baseChatLayer.setBorder(new EmptyBorder(0,25,0,0));

        // Create a base panel to hold chat elements
        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(400,600));
        basePanel.setBackground(new Color(68,114,196));

        // Panel to display saved chat history
        JPanel savedChatPanel = new JPanel();
        savedChatPanel.setPreferredSize(new Dimension(385, 535));
        savedChatPanel.setBackground(new Color(143,170,220));

        // Example saved chat text
        JLabel textArea = new JLabel();
        textArea.setText("<html>Steve had played column 3. <br> Ved had played column 4.</html>");
        savedChatPanel.add(textArea);

        // Text area for new messages
        JTextArea chatBox = new JTextArea("Chat");
        chatBox.setPreferredSize(new Dimension(305,50));
        chatBox.setBackground(Color.white);
        chatBox.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        // Button to send messages
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setPreferredSize(new Dimension(80,50));
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        // Add components to the base panel
        basePanel.add(savedChatPanel);
        basePanel.add(chatBox);
        basePanel.add(sendButton);

        // Add base panel to the layered pane
        baseChatLayer.add(basePanel);

        return baseChatLayer;
    }

}