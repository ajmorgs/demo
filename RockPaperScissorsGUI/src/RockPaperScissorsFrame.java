import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RockPaperScissorsFrame extends JFrame {


    JButton quitButton;JButton rockButton;JButton paperButton;JButton scissorsButton;
    ImageIcon quitIcon;ImageIcon rockIcon;ImageIcon paperIcon;ImageIcon scissorsIcon;
    JTextArea statusText;
    JPanel buttonPanel; JPanel statsPanel; JPanel resultsPanel;
    JScrollPane scrollPane;
    JTextField userWins; JTextField computerWins; JTextField ties;
    JLabel userLabel;JLabel computerLabel;JLabel tiesLabel;

    public RockPaperScissorsFrame() throws HeadlessException {
        createComponents();
    }

    private void createComponents() {

        //top - 4 buttons with icons



        statusText = new JTextArea(10,40);
        statusText.setEditable(false);
        statusText.setFont(new Font("Serif", Font.ITALIC, 16));
        statusText.setLineWrap(true);
        statusText.setWrapStyleWord(true);

        middlePanel = new JPanel();
        // middlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        scrollPane = new JScrollPane(statusText);
        scrollPane.setPreferredSize(new Dimension(750, 400));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //create grid
        setSize(600, 700);

        GridLayout gameLayout = new GridLayout(3,3);
        setLayout(gameLayout);

     /*   msgLabel = new JLabel("",JLabel.CENTER );
        msgLabel.setSize(600,100);
        msgLabel.setText("Welcome to Tic Tac Toe");
        msgLabel.setFont(new Font("Arial", Font.PLAIN, 32));
*/
        JPanel statsPanel = new JPanel();
      //  topPanel.add(msgLabel);

        add(statsPanel);

      /*  gamePanel=new JPanel();
        gamePanel.setLayout(new GridLayout(3,3));

        TicTacToeButton [] button = new TicTacToeButton[9];
        TicTacToeListener btnListener = new TicTacToeListener();

        for(int x=0;x<9;x++){
            button[x] = new TicTacToeButton();
            button[x].setMinimumSize(new Dimension(200, 200));
            button[x].setMaximumSize(new Dimension(200, 200));
            button[x].setText(" ");
            button[x].setFont(new Font("Arial", Font.BOLD, 32));
            button[x].putClientProperty("index",new Integer[]{x});
            button[x].addActionListener(btnListener);
            gamePanel.add(button[x]);
        }

        add(gamePanel);*/

        quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> System.exit(0));

        setBounds(400,400,600,600);
        repaint();
        setTitle("Rock Paper Scissors Game”");

    }
}
