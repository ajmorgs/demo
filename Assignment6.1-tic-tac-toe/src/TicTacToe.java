/**
 A 3 x 3 tic-tac-toe board.
 */
public class TicTacToe
{
    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    private int turns=0;
    String gameStatus="";
    /**
     Constructs an empty board.
     */
    public TicTacToe()
    {
        board = new String[ROWS][COLUMNS];
        // Fill with spaces
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                board[i][j] = " ";
    }

    /**
     Sets a field in the board. The field must be unoccupied.
     @param i the row index
     @param j the column index
     @param player the player ("x" or "o")
     */
    public void set(int i, int j, String player)
    {
        if (board[i][j].equals(" "))
            board[i][j] = player;
    }

    /**
     Creates a string representation of the board, such as
     |x  o|
     |  x |
     |   o|
     @return the string representation
     */
    public String toString()
    {
        String r = "";
        for (int i = 0; i < ROWS; i++)
        {
            r = r + "|";
            for (int j = 0; j < COLUMNS; j++)
                r = r + board[i][j];
            r = r + "|\n";
        }
        return r;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public String checkGameStatus(){
        String status="";
        int fullrow = 0;

        for (int i = 0; i < ROWS; i++)
        {
            if(!board[0][0].equals(" ")) {
                //check first row, column and diagonal
                if (board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) {
                    status = board[0][0] + " wins";
                }
                if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
                    status = board[0][0] + " wins";
                }
                if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])) {
                    status = board[0][0] + " wins";
                }
            }
            if(!board[0][1].equals(" ")) {
                //check second column
                if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1])) {
                    status = board[0][1] + " wins";
                }
            }
            if(!board[0][2].equals(" ")) {
                //check third column and diagonal
                if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
                    status = board[0][2] + " wins";
                }
                if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2])) {
                    status = board[0][2] + " wins";
                }
            }
            if(!board[1][0].equals(" ")) {
                //check 2nd row
                if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])) {
                    status = board[1][0] + " wins";
                }
            }
            if(!board[2][0].equals(" ")) {
                //check 3rd row
                if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) {
                    status = board[2][0] + " wins";
                }
            }
        }
        if(this.turns==9 && status.equals("")){
            status="Game is a tie";
        }

        return status;
    }
}