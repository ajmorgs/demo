import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentListener;

public class GameFrame extends JFrame {

    private JLabel msgLabel;
    private JOptionPane optionPane;
    String whose_turn="X";
    TicTacToe game;

    public void setGame(TicTacToe game) {
        this.game = game;
    }

    public GameFrame() throws HeadlessException {
        createComponents();
    }

    private void createComponents() {
        //create grid
        setSize(600, 700);

        GridLayout gameLayout = new GridLayout(3,3);
        setLayout(gameLayout);

        msgLabel = new JLabel("",JLabel.CENTER );
        msgLabel.setSize(600,100);
        msgLabel.setText("Welcome to Tic Tac Toe");
        msgLabel.setFont(new Font("Arial", Font.PLAIN, 32));

        JPanel topPanel = new JPanel();
        topPanel.add(msgLabel);

        add(topPanel);

        JPanel gamePanel=new JPanel();
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

        add(gamePanel);

        setBounds(400,400,600,600);
        repaint();
        setTitle("Tic Tac Toe");

    }

    class TicTacToeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton btn=(JButton)e.getSource();
            Integer[] index=(Integer[]) btn.getClientProperty("index");

            btn.setText(whose_turn);
            btn.setEnabled(false);
            int row=(index[0]/3);
            int col=(index[0] % 3);

            System.out.println(row + "," + col);

            game.set(row,col,whose_turn);

            //check for win/tie
            game.checkGameStatus();

            //set for next turn
            if(whose_turn.equals("X")){
                whose_turn = "O";
            }
            else{whose_turn="X";}

        }
    }

}
