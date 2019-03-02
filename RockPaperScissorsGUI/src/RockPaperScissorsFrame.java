import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RockPaperScissorsFrame extends JFrame {

    JButton quitButton;
    GameButton rockButton;GameButton paperButton;GameButton scissorsButton;
    ImageIcon quitIcon;ImageIcon rockIcon;ImageIcon paperIcon;ImageIcon scissorsIcon;
    JTextArea statusText;
    JPanel buttonPanel; JPanel statsPanel; JPanel resultsPanel;
    JScrollPane scrollPane;
    JTextField userWins; JTextField computerWins; JTextField ties;
    JLabel userLabel;JLabel computerLabel;JLabel tiesLabel;
    int rocks; int papers; int scissors;
    int pc_rocks; int pc_papers; int pc_scissors;
    ArrayList<String> opts = new ArrayList<>();
    int number_of_games=0;
    String userChoice="";
    String computerChoice="";

    public RockPaperScissorsFrame() throws HeadlessException {
        createComponents();
    }

    private void createComponents() {

        opts.add("rock");
        opts.add("paper");
        opts.add("scissors");

        GameListener btnListener = new GameListener();

        //top - 4 buttons with icons

        quitIcon = new ImageIcon(getClass().getResource("quit.jpg"));
        rockIcon = new ImageIcon(getClass().getResource("rock.jpg"));
        paperIcon = new ImageIcon(getClass().getResource("paper.jpg"));
        scissorsIcon = new ImageIcon(getClass().getResource("scissors.jpg"));

        quitButton = new JButton(quitIcon);
        quitButton.setPreferredSize(new Dimension(100,100));
        quitButton.addActionListener((ActionEvent event) -> System.exit(0));
        quitButton.setMargin(new Insets(20, 40, 20, 20));

        rockButton = new GameButton(rockIcon,"rock");
        rockButton.addActionListener(btnListener);
        paperButton=new GameButton(paperIcon,"paper");
        paperButton.addActionListener(btnListener);
        scissorsButton=new GameButton(scissorsIcon,"scissors");
        scissorsButton.addActionListener(btnListener);

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

            int x= ThreadLocalRandom.current().nextInt(0, 2+1);

            //statusText.append(btn.getClientProperty("symbol").toString() + "\n");
            System.out.println(btn.getClientProperty("symbol").toString());
            userChoice=btn.getClientProperty("symbol").toString();

            //get computer choice

            if(number_of_games % 10 == 1){
                //computer cheats


            }
            System.out.println(rocks);
        }

    }
    class GameButton extends JButton  {

      public GameButton(Icon icon, String s) {
          super(icon);
          setHorizontalAlignment(SwingConstants.CENTER);
          setPreferredSize(new Dimension(100,100));
          putClientProperty("symbol",s);
      }
    }
    String JudgeGame(String userChoice,String computerChoice,int cheat){
        String ruling = "";

        if (userChoice.equals(computerChoice) && cheat < 1) {
            ruling = "Game is a tie";
        }
        switch(userChoice){
            case "rock":
                rocks=rocks+1;
                if(computerChoice.equals("scissors") && cheat < 1){
                    ruling = "Rock breaks Scissors (Player Wins)";

                }
                break;
            case "paper":
                papers=papers+1;
                if(computerChoice.equals("rock") && cheat < 1){
                    ruling = "Paper covers Rock (Player Wins)";

                }
                break;
            case "scissors":
                scissors=scissors+1;
                if(computerChoice.equals("paper") && cheat < 1){
                    ruling = "Scissors cut Paper (Player Wins)";

                }
                break;
            default:
                break;
        }

        return ruling;
    }
}
