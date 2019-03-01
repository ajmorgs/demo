import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame {

    JButton quitButton;JButton rockButton;JButton paperButton;JButton scissorsButton;
    ImageIcon quitIcon;ImageIcon rockIcon;ImageIcon paperIcon;ImageIcon scissorsIcon;
    JTextArea statusText;
    JPanel buttonPanel; JPanel statsPanel; JPanel resultsPanel;
    JScrollPane scrollPane;
    JTextField userWins; JTextField computerWins; JTextField ties;
    JLabel userLabel;JLabel computerLabel;JLabel tiesLabel;
    int rocks; int papers; int scissors;
    int pc_rocks; int pc_papers; int pc_scissors;

    public RockPaperScissorsFrame() throws HeadlessException {
        createComponents();
    }

    private void createComponents() {

        //top - 4 buttons with icons
        GameListener btnListener = new GameListener();

        quitIcon = new ImageIcon(getClass().getResource("quit.jpg"));
        rockIcon = new ImageIcon(getClass().getResource("rock.jpg"));
        paperIcon = new ImageIcon(getClass().getResource("paper.jpg"));
        scissorsIcon = new ImageIcon(getClass().getResource("scissors.jpg"));

        quitButton = new JButton("Quit");
        quitButton.setIcon(quitIcon);
        quitButton.setPreferredSize(new Dimension(100,100));
        quitButton.addActionListener((ActionEvent event) -> System.exit(0));
        quitButton.setMargin(new Insets(20, 40, 20, 20));

        rockButton = new JButton();
        rockButton.setIcon(rockIcon);
        rockButton.setPreferredSize(new Dimension(100,100));
        rockButton.setHorizontalAlignment(SwingConstants.CENTER);
        rockButton.putClientProperty("symbol","rock");
        rockButton.addActionListener(btnListener);

        paperButton=new JButton();
        paperButton.setIcon(paperIcon);
        paperButton.setPreferredSize(new Dimension(100,100));
        paperButton.setHorizontalAlignment(SwingConstants.CENTER);
        scissorsButton=new JButton();
        scissorsButton.setIcon(scissorsIcon);
        scissorsButton.setPreferredSize(new Dimension(100,100));
        scissorsButton.setHorizontalAlignment(SwingConstants.CENTER);

        buttonPanel=new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300,200));
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.NORTH);

        statsPanel = new JPanel();

        userLabel=new JLabel("User Wins: ");
        userWins=new JTextField(10);
        computerLabel=new JLabel("Computer Wins: ");
        computerWins=new JTextField(10);
        tiesLabel=new JLabel("Ties: ");
        ties=new JTextField(10);

        statsPanel.add(userLabel);
        statsPanel.add(userWins);
        statsPanel.add(computerLabel);
        statsPanel.add(computerWins);
        statsPanel.add(tiesLabel);
        statsPanel.add(ties);

        add(statsPanel);

        statusText = new JTextArea(10,40);
        statusText.setEditable(false);
        statusText.setFont(new Font("Serif", Font.ITALIC, 16));
        statusText.setLineWrap(true);
        statusText.setWrapStyleWord(true);

        scrollPane = new JScrollPane(statusText);
        scrollPane.setPreferredSize(new Dimension(250, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        resultsPanel = new JPanel();
        resultsPanel.add(scrollPane);

        add(resultsPanel);

        setSize(800, 700);
        setBounds(400,400,600,600);
        repaint();
        setTitle("Rock Paper Scissors Game”");

    }

    class GameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn=(JButton)e.getSource();
            statusText.setText(btn.getClientProperty("symbol").toString());
        }

    }
}
