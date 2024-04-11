import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

/**
 * A class representing a chat box GUI component.
 */
public class ChatBox {

    private JTextArea chatTextArea;
    private JButton sendButton;
    private Network network;

    /**
     * Constructs a new ChatBox instance.
     */
    ChatBox(Network network){
        this.network=network;
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
        chatTextArea = new JTextArea();
        chatTextArea.setBackground(new Color(143,170,220));
        chatTextArea.setFont(new Font("Calibri", BOLD,18));
        chatTextArea.setForeground(Color.yellow);
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        scrollPane.setPreferredSize(new Dimension(385, 535));
        scrollPane.setBorder(null);
        savedChatPanel.add(scrollPane);


        // Text area for new messages
        JTextArea inputTextArea = new JTextArea();
        inputTextArea.setPreferredSize(new Dimension(305,50));
        inputTextArea.setBackground(Color.white);
        inputTextArea.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        // Button to send messages
        sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setPreferredSize(new Dimension(80,50));
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(inputTextArea.getText());
                inputTextArea.setText(""); // Clear the input text area after sending
            }
        });

        // Add components to the base panel
        basePanel.add(savedChatPanel);
        basePanel.add(inputTextArea);
        basePanel.add(sendButton);

        // Add base panel to the layered pane
        baseChatLayer.add(basePanel);

        return baseChatLayer;
    }

    private void sendMessage(String message) {
        if (!message.isEmpty()) {
            network.sendMessage("4#" + message); // Protocol 4 is for chat messages
            appendMessage("You : " + message); // Add the sent message to the chat box
        }
    }

    // Method to append a received message to the chat box
    public void appendMessage(String message) {
        chatTextArea.append("\n" + message);
    }

}