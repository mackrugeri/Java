import java.awt.*;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;


public class xyz extends Applet {
    public void init() {



    }
    public void main(String[] args) {

        setLayout(null);
        setBackground(new Color(255,255,255));
        CheckerDesign board = new CheckerDesign();
        add(board);
        board.message.setForeground(Color.BLACK);
        board.message.setFont(new Font("Serif", Font.BOLD, 30));
        add(board.message);
        board.setBounds(40*2,40*2,328*2,328*2);
        board.newGameButton.setBounds(420*2, 120*2, 200*2, 60*2);
        board.resignButton.setBounds(420*2, 240*2, 200*2, 60*2);
        board.message.setBounds(0*2, 200*2, 660*2, 60*2);

    }
    public void paint(Graphics g){

        resize(800,750);
    }

}

class CheckersMove {
    public int StartRow;
    public int StartCol;
    public int EndRow;
    public int EndCol;

    CheckersMove(int row, int co1, int rowEnd, int colEnd) {
        StartRow = row;
        StartCol = co1;
        EndRow = rowEnd;
        EndCol = colEnd;
    }
    boolean isJump() {
        return (StartRow - EndRow == 2 || StartRow - EndRow == -2);
    }
}
class CheckerDesign extends Canvas implements ActionListener, MouseListener {


    Button resignButton;
    Button newGameButton;
    Label message;
    Checker board;
    boolean gameInProgress;
    int PlayerTurn;
    int selectedRow;
    int selectedCol;
    CheckersMove[] legalMoves;

    public CheckerDesign() {
        setBackground(Color.black);
        addMouseListener(this);
        setFont(new  Font("Serif", Font.BOLD, 300));
        resignButton = new Button("Resign");
        newGameButton = new Button("New Game");

        message = new Label("",Label.RIGHT);
        board = new Checker();
        doNewGame();
    }


    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == newGameButton)
            doNewGame();
        else if (src == resignButton)
            doResign();
    }


    void doNewGame() {
        if (gameInProgress == true) {
            message.setText("Finish the current game first!");
            return;
        }
        board.setUpGame();
        PlayerTurn = Checker.BLACK;
        legalMoves = board.getLegalMoves(Checker.BLACK);
        selectedRow = -1;
        message.setText("Black:  Make your move.");
        gameInProgress = true;
        newGameButton.setEnabled(false);
        resignButton.setEnabled(true);
        repaint();
    }


    void doResign() {
        if (gameInProgress == false) {
            message.setText("There is no game in progress!");
            return;
        }
        if (PlayerTurn == Checker.RED)
            gameOver("RED resigns.  BLACK wins.");
        else
            gameOver("BLACK resigns.  RED winds.");
    }


    void gameOver(String str) {
        message.setText(str);
        newGameButton.setEnabled(true);
        resignButton.setEnabled(false);
        gameInProgress = false;
    }


    void doClickSquare(int row, int col) {

        for (int i = 0; i < legalMoves.length; i++)
            if (legalMoves[i].StartRow == row && legalMoves[i].StartCol == col) {
                selectedRow = row;
                selectedCol = col;
                if (PlayerTurn == Checker.RED)
                    message.setText("Black:  Make your move.");
                else
                    message.setText("red:  Make your move.");
                repaint();
                return;
            }

        if (selectedRow < 0) {
            message.setText("Click the piece you want to move.");
            return;
        }

        for (int i = 0; i < legalMoves.length; i++)
            if (legalMoves[i].StartRow == selectedRow && legalMoves[i].StartCol == selectedCol
                    && legalMoves[i].EndRow == row && legalMoves[i].EndCol == col) {
                doMakeMove(legalMoves[i]);
                return;
            }
        message.setText("Click the square you want to move to.");

    }


    void doMakeMove(CheckersMove move) {
        board.makeMove(move);
        if (move.isJump()) {
            legalMoves = board.getLegalJumpsFrom(PlayerTurn,move.EndRow,move.EndCol);
            if (legalMoves != null) {
                if (PlayerTurn == Checker.RED)
                    message.setText("Black: its jump time");
                else
                    message.setText("Red: its jump time");
                selectedRow = move.EndRow;  // Since only one piece can be moved, select it.
                selectedCol = move.EndCol;
                repaint();
                return;
            }
        }

        if (PlayerTurn == Checker.RED) {
            PlayerTurn = Checker.BLACK;
            legalMoves = board.getLegalMoves(PlayerTurn);
            if (legalMoves == null)
                message.setText("Black is winner.");
            else if (legalMoves[0].isJump())
                message.setText("BLack is able to kill");
            else
                message.setText("Red its your turn");
        }
        else {
            PlayerTurn = Checker.RED;
            legalMoves = board.getLegalMoves(PlayerTurn);
            if (legalMoves == null)
                message.setText(" Red is winner.");
            else if (legalMoves[0].isJump())
                message.setText("red is able to kill");
            else
                message.setText("Black its your turn");
        }
        selectedRow = -1;
        if (legalMoves != null) {
            boolean sameStartSquare = true;
            for (int i = 1; i < legalMoves.length; i++)
                if (legalMoves[i].StartRow != legalMoves[0].StartRow
                        || legalMoves[i].StartCol != legalMoves[0].StartCol) {
                    sameStartSquare = false;
                    break;
                }
            if (sameStartSquare) {
                selectedRow = legalMoves[0].StartRow;
                selectedCol = legalMoves[0].StartCol;
            }
        }
        repaint();

    }


    public void update(Graphics g) {
        paint(g);
    }


    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.drawRect(1,1,getSize().width-3,getSize().height-3);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ( row % 2 == col % 2 )
                    g.setColor(Color.lightGray);
                else
                    g.setColor(Color.gray);
                g.fillRect(2 + col*20*4, 2 + row*20*4, 20*4, 20*4);
                switch (board.pieceAt(row,col)) {
                    case Checker.RED:
                        g.setColor(Color.red);
                        g.fillOval(4 + col*20*4, 4 + row*20*4, 16*4, 16*4);
                        break;
                    case Checker.BLACK:
                        g.setColor(Color.black);
                        g.fillOval(4 + col*20*4, 4 + row*20*4, 16*4, 16*4);
                        break;
                    case Checker.RED_KING:
                        g.setColor(Color.red);
                        g.fillOval(4 + col*20*4, 4 + row*20*4, 16*4, 16*4);
                        g.setColor(Color.white);
                        g.drawString("K", 7 + col*20*4, 16 + row*20*4);
                        break;
                    case Checker.BLACK_KING:
                        g.setColor(Color.black);
                        g.fillOval(4 + col*20*4, 4 + row*20*4, 16*4, 16*4);
                        g.setColor(Color.white);
                        g.drawString("K", 7 + col*20*4, 16 + row*20*4);
                        break;
                }
            }
        }

        if (gameInProgress) {
            g.setColor(Color.cyan);
            for (int i = 0; i < legalMoves.length; i++) {
                g.drawRect(2 + legalMoves[i].StartCol*20*4, 2 + legalMoves[i].StartRow*20*4, 19*4, 19*4);
            }
            if (selectedRow >= 0) {
                g.setColor(Color.white);
                g.drawRect(2 + selectedCol*20*4, 2 + selectedRow*20*4, 19*4, 19*4);
                g.drawRect(3 + selectedCol*20*4, 3 + selectedRow*20*4, 17*4, 17*4);
                g.setColor(Color.green);
                for (int i = 0; i < legalMoves.length; i++) {
                    if (legalMoves[i].StartCol == selectedCol && legalMoves[i].StartRow == selectedRow)
                        g.drawRect(2 + legalMoves[i].EndCol*20*4, 2 + legalMoves[i].EndRow*20*4, 19*4, 19*4);
                }
            }
        }
    }


    public Dimension getPreferredSize() {

        return new Dimension(164*4, 164*4);
    }


    public Dimension getMinimumSize() {

        return new Dimension(164*4, 164*4);
    }


    public void mousePressed(MouseEvent evt) {
        if (gameInProgress == false)
            message.setText("Click \"New Game\" to start a new game.");
        else {
            int col = (evt.getX() - 2) / (20*4);
            int row = (evt.getY() - 2) / (20*4);

            if (col >= 0 && col < 8 && row >= 0 && row < 8)
            {
                doClickSquare(row, col);
            }
        }
    }


    public void mouseReleased(MouseEvent evt) {

    }
    public void mouseClicked(MouseEvent evt) {

    }
    public void mouseEntered(MouseEvent evt) {

    }
    public void mouseExited(MouseEvent evt) {

    }


}

class Checker {

    public static final int
            EMPTY = 0,
            RED = 1,
            RED_KING = 2,
            BLACK = 3,
            BLACK_KING = 4;

    private int[][] board;


    public Checker() {
        board = new int[8][8];
        setUpGame();
    }

    public void setUpGame() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ( row % 2 == col % 2 ) {
                    if (row < 3)
                        board[row][col] = BLACK;
                    else if (row > 4)
                        board[row][col] = RED;
                    else
                        board[row][col] = EMPTY;
                }
                else {
                    board[row][col] = EMPTY;
                }
            }
        }
    }


    public int pieceAt(int row, int col) {
        return board[row][col];
    }


    public void makeMove(CheckersMove move)
    {

        makeMove(move.StartRow, move.StartCol, move.EndRow, move.EndCol);
    }


    public void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        board[toRow][toCol] = board[fromRow][fromCol];
        board[fromRow][fromCol] = EMPTY;
        if (fromRow - toRow == 2 || fromRow - toRow == -2) {
            int jumpRow = (fromRow + toRow) / 2;
            int jumpCol = (fromCol + toCol) / 2;
            board[jumpRow][jumpCol] = EMPTY;
        }
        if (toRow == 0 && board[toRow][toCol] == RED)
            board[toRow][toCol] = RED_KING;
        if (toRow == 7 && board[toRow][toCol] == BLACK)
            board[toRow][toCol] = BLACK_KING;
    }


    public CheckersMove[] getLegalMoves(int player) {
        if (player != RED && player != BLACK)
            return null;

        int playerKing;
        if (player == RED)
            playerKing = RED_KING;
        else
            playerKing = BLACK_KING;

        Vector moves = new Vector();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == player || board[row][col] == playerKing) {
                    if (canJump(player, row, col, row+1, col+1, row+2, col+2))
                        moves.addElement(new CheckersMove(row, col, row+2, col+2));
                    if (canJump(player, row, col, row-1, col+1, row-2, col+2))
                        moves.addElement(new CheckersMove(row, col, row-2, col+2));
                    if (canJump(player, row, col, row+1, col-1, row+2, col-2))
                        moves.addElement(new CheckersMove(row, col, row+2, col-2));
                    if (canJump(player, row, col, row-1, col-1, row-2, col-2))
                        moves.addElement(new CheckersMove(row, col, row-2, col-2));
                }
            }
        }

        if (moves.size() == 0) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (board[row][col] == player || board[row][col] == playerKing) {
                        if (canMove(player,row,col,row+1,col+1))
                            moves.addElement(new CheckersMove(row,col,row+1,col+1));
                        if (canMove(player,row,col,row-1,col+1))
                            moves.addElement(new CheckersMove(row,col,row-1,col+1));
                        if (canMove(player,row,col,row+1,col-1))
                            moves.addElement(new CheckersMove(row,col,row+1,col-1));
                        if (canMove(player,row,col,row-1,col-1))
                            moves.addElement(new CheckersMove(row,col,row-1,col-1));
                    }
                }
            }
        }

        if (moves.size() == 0)
            return null;
        else {
            CheckersMove[] moveArray = new CheckersMove[moves.size()];
            for (int i = 0; i < moves.size(); i++)
                moveArray[i] = (CheckersMove)moves.elementAt(i);
            return moveArray;
        }

    }


    public CheckersMove[] getLegalJumpsFrom(int player, int row, int col) {
        if (player != RED && player != BLACK)
            return null;
        int playerKing;  // The constant representing a King belonging to player.
        if (player == RED)
            playerKing = RED_KING;
        else
            playerKing = BLACK_KING;
        Vector moves = new Vector();  // The legal jumps will be stored in this vector.
        if (board[row][col] == player || board[row][col] == playerKing) {
            if (canJump(player, row, col, row+1, col+1, row+2, col+2))
                moves.addElement(new CheckersMove(row, col, row+2, col+2));
            if (canJump(player, row, col, row-1, col+1, row-2, col+2))
                moves.addElement(new CheckersMove(row, col, row-2, col+2));
            if (canJump(player, row, col, row+1, col-1, row+2, col-2))
                moves.addElement(new CheckersMove(row, col, row+2, col-2));
            if (canJump(player, row, col, row-1, col-1, row-2, col-2))
                moves.addElement(new CheckersMove(row, col, row-2, col-2));
        }
        if (moves.size() == 0)
            return null;
        else {
            CheckersMove[] moveArray = new CheckersMove[moves.size()];
            for (int i = 0; i < moves.size(); i++)
                moveArray[i] = (CheckersMove)moves.elementAt(i);
            return moveArray;
        }
    }  // end getLegalMovesFrom()


    private boolean canJump(int player, int r1, int c1, int r2, int c2, int r3, int c3) {
        if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
            return false;  // (r3,c3) is off the board.

        if (board[r3][c3] != EMPTY)
            return false;  // (r3,c3) already contains a piece.

        if (player == RED) {
            if (board[r1][c1] == RED && r3 > r1)
                return false;  // Regular red piece can only move  up.
            if (board[r2][c2] != BLACK && board[r2][c2] != BLACK_KING)
                return false;  // There is no black piece to jump.
            return true;  // The jump is legal.
        }
        else {
            if (board[r1][c1] == BLACK && r3 < r1)
                return false;  // Regular black piece can only move downn.
            if (board[r2][c2] != RED && board[r2][c2] != RED_KING)
                return false;  // There is no red piece to jump.
            return true;  // The jump is legal.
        }

    }


    private boolean canMove(int player, int r1, int c1, int r2, int c2) {
        if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8)
            return false;  // (r2,c2) is off the board.

        if (board[r2][c2] != EMPTY)
            return false;  // (r2,c2) already contains a piece.

        if (player == RED) {
            if (board[r1][c1] == RED && r2 > r1)
                return false;  // Regualr red piece can only move down.
            return true;  // The move is legal.
        }
        else {
            if (board[r1][c1] == BLACK && r2 < r1)
                return false;  // Regular black piece can only move up.
            return true;  // The move is legal.
        }

    }


}












