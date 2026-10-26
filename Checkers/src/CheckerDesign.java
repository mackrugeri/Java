import java.awt.*;
import java.awt.event.*;

public class CheckerDesign extends Canvas implements ActionListener, MouseListener {


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

