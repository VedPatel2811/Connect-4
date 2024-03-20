import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class StartGame implements ActionListener {
    private String player1Token;
    private String  player2Token;
    private String name1;
    private String name2;
    private JButton startGame;
    private JFrame baseStartPanel;
    private JTextField player1Name;
    private JTextField player2Name;
    public ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Orange", "Green", "Blue", "Yellow", "Pink", "Purple", "Black"));
    public JComboBox<String> player1ColorBox;
    public JComboBox<String> player2ColorBox;


    StartGame(){

    }

    public JFrame StartMenu(){
        baseStartPanel = new JFrame();
        baseStartPanel.getContentPane().setBackground(new Color(143, 170, 220));

        baseStartPanel.setDefaultCloseOperation(baseStartPanel.EXIT_ON_CLOSE);
        baseStartPanel.setPreferredSize(new Dimension(300, 225));

        baseStartPanel.setLayout(new FlowLayout());

        player1Name = Player1Name();
        player2Name = Player2Name();
        startGame = StartGame();
        player1ColorBox = ColorSelection();
        player2ColorBox = ColorSelection();
        startGame.addActionListener(this);
        player1ColorBox.addActionListener(this);
        player2ColorBox.addActionListener(this);

        baseStartPanel.add(new JLabel("Player 1 Name "));
        baseStartPanel.add(player1Name);
        baseStartPanel.add(new JLabel("Player 2 Name "));
        baseStartPanel.add(player2Name);
        baseStartPanel.add(new JLabel("Player 1 Color"));
        baseStartPanel.add(player1ColorBox);
        baseStartPanel.add(new JLabel("Player 2 Color"));
        baseStartPanel.add(player2ColorBox);
        baseStartPanel.add(startGame);

        ImageIcon image = new ImageIcon("A12Logo.png");
        baseStartPanel.setIconImage(image.getImage());
        baseStartPanel.pack();
        baseStartPanel.setVisible(true);

        return baseStartPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==player1ColorBox){
            player1Token=(String) player1ColorBox.getSelectedItem();
            colors.remove(player1Token);
            player2ColorBox.setModel(new DefaultComboBoxModel<>(colors.toArray(new String[0])));
        }
        if(e.getSource()==player2ColorBox){
            player2Token=(String) player2ColorBox.getSelectedItem();
            colors.remove(player2Token);
        }
        if(e.getSource()==startGame){
            name1 = player1Name.getText();
            name2 = player2Name.getText();

            baseStartPanel.dispose();
            Main main = new Main();
            main.StartMainGame(name1, name2, player1Token, player2Token);

        }
    }


    private JTextField Player1Name(){
        JTextField player1Name = new JTextField();
        player1Name.setPreferredSize(new Dimension(150, 30));
        player1Name.setBackground(new Color(180,199,231));
        player1Name.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return player1Name;
    }

    private JTextField Player2Name(){
        JTextField player2Name = new JTextField();
        player2Name.setPreferredSize(new Dimension(150, 30));
        player2Name.setBackground(new Color(180,199,231));
        player2Name.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return player2Name;
    }

    private JComboBox<String> ColorSelection() {
        JComboBox<String> colorBox = new JComboBox<>(colors.toArray(new String[0]));
        colorBox.setPreferredSize(new Dimension(150, 30));
        colorBox.setBackground(new Color(180,199,231));
        colorBox.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        return colorBox;
    }

    private JButton StartGame(){
        JButton startButton = new JButton("Start Game");
        startButton.setBackground(new Color(53, 90, 156));
        startButton.setForeground(Color.YELLOW);
        startButton.setBorder(BorderFactory.createLineBorder(new Color(32,56,100), 2));
        startButton.setPreferredSize(new Dimension(100,30));
        return startButton;
    }
    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }


}
