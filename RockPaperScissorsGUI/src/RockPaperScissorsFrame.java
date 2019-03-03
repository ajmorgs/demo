import javax.swing.*;
import javax.swing.border.Border;
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
    JTextField txtUserWins; JTextField txtComputerWins; JTextField txtTies;
    JLabel userLabel;JLabel computerLabel;JLabel tiesLabel;
    int rocks; int papers; int scissors;
    int pc_rocks; int pc_papers; int pc_scissors;
    ArrayList<String> opts = new ArrayList<>();
    int number_of_games=0;
    String userChoice="";
    String computerChoice="";
    int userWins=0;int computerWins=0; int ties=0;

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
        quitButton.setPreferredSize(new Dimension(100,80));
        quitButton.addActionListener((ActionEvent event) -> System.exit(0));
        quitButton.setMargin(new Insets(5, 5, 5, 5));

        rockButton = new GameButton(rockIcon,"rock");
        rockButton.addActionListener(btnListener);
        paperButton=new GameButton(paperIcon,"paper");
        paperButton.addActionListener(btnListener);
        scissorsButton=new GameButton(scissorsIcon,"scissors");
        scissorsButton.addActionListener(btnListener);

        buttonPanel=new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200,200));
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.NORTH);

        statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(100,100));
        userLabel=new JLabel("User Wins: ");
        txtUserWins=new JTextField(10);
        computerLabel=new JLabel("Computer Wins: ");
        txtComputerWins=new JTextField(10);
        tiesLabel=new JLabel("Ties: ");
        txtTies=new JTextField(10);

        statsPanel.add(userLabel);
        statsPanel.add(txtUserWins);
        statsPanel.add(computerLabel);
        statsPanel.add(txtComputerWins);
        statsPanel.add(tiesLabel);
        statsPanel.add(txtTies);

        add(statsPanel, BorderLayout.CENTER);

        statusText = new JTextArea(10,40);
        statusText.setEditable(false);
        statusText.setFont(new Font("Serif", Font.ITALIC, 16));
        statusText.setLineWrap(true);
        statusText.setWrapStyleWord(true);

        scrollPane = new JScrollPane(statusText);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        resultsPanel = new JPanel();
        resultsPanel.add(scrollPane);


        add(resultsPanel,BorderLayout.SOUTH);

        setSize(800, 800);
        setBounds(200,200,600,600);
        repaint();
        setTitle("Rock Paper Scissors Game”");

    }

    class GameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn=(JButton)e.getSource();

            int x= ThreadLocalRandom.current().nextInt(0, 2+1);

            userChoice=btn.getClientProperty("symbol").toString();

            number_of_games+=1;
            int cheat=0;
            //get computer choice
            if(number_of_games % 10 == 1){
                //computer cheats
                cheat=1;
            }else{
                computerChoice=opts.get(x);
            }
//computerChoice="scissors";

            statusText.append(JudgeGame(userChoice,computerChoice,cheat) + "\n");
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
            ruling = "Game is a tie";ties+=1;
        }else{
            switch(userChoice){
                case "rock":
                    rocks=rocks+1;
                    if(computerChoice.equals("scissors") && cheat < 1){
                        ruling = "Rock breaks Scissors (Player Wins)";userWins+=1;
                    }else{
                        ruling = "Paper covers Rock (Computer Wins)";computerWins+=1;
                    }
                    break;
                case "paper":
                    papers=papers+1;
                    if(computerChoice.equals("rock") && cheat < 1){
                        ruling = "Paper covers Rock (Player Wins)";userWins+=1;
                    }else{
                        ruling = "Scissors cuts Paper (Computer Wins)";computerWins+=1;
                    }
                    break;
                case "scissors":
                    scissors=scissors+1;
                    if(computerChoice.equals("paper") && cheat < 1){
                        ruling = "Scissors cut Paper (Player Wins)";userWins+=1;
                    }else{
                        ruling = "Rock breaks Scissors (Computer Wins)";computerWins+=1;
                    }
                    break;
                default:
                    break;
            }
        }


        txtUserWins.setText(Integer.toString(userWins));
        txtComputerWins.setText(Integer.toString(computerWins));
        txtTies.setText(Integer.toString(ties));

        return ruling;
    }
}
