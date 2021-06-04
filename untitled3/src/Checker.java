import java.util.Vector;

public class Checker {

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