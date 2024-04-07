import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * A class representing a chat box GUI component.
 */
public class ChatBox {

    private JTextArea textArea;
    private JTextArea chatBox;
    private Network server;
    private Network client;
    /**
     * Constructs a new ChatBox instance.
     */
    ChatBox(){

    }

    /**
     * Constructs and returns the main chat box component.
     * @return The main chat box component.
     */
    public JLayeredPane MainChatBox(Network server, Network client){
        this.server=server;
        this.client=client;

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
        textArea = new JTextArea();
        textArea.setEditable(false); // Disable editing of chat history
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        savedChatPanel.add(textArea);

        // Text area for new messages
        chatBox = new JTextArea("Chat");
        chatBox.setPreferredSize(new Dimension(305,50));
        chatBox.setBackground(Color.white);
        chatBox.setBorder(BorderFactory.createLineBorder(new Color(68,114,196),5));

        // Button to send messages
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.red);
        sendButton.setPreferredSize(new Dimension(80, 50));
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(68, 114, 196), 5));
        sendButton.addActionListener(e -> {
            sendMessage(chatBox.getText());
            chatBox.setText("");
        });

        // Add components to the base panel
        basePanel.add(savedChatPanel);
        basePanel.add(chatBox);
        basePanel.add(sendButton);

        // Add base panel to the layered pane
        baseChatLayer.add(basePanel);

        return baseChatLayer;
    }

    public void sendMessage(String message) {
        if (!message.isEmpty()) {
            if (server != null) {
                server.sendMessage(message);
            } else if (client != null) {
                client.sendMessage(message);
            }
            appendMessage("You: " + message);
        }
    }

    public void receiveMessage() {
        String message;
        if (server != null) {
            message = server.receiveMessage();
        } else {
            message = client.receiveMessage();
        }
        appendMessage("Opponent: " + message);
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(message + "\n");
            textArea.setCaretPosition(textArea.getDocument().getLength()); // Scroll to the bottom
        });
    }
}
