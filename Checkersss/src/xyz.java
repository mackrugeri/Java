import java.awt.*;
import java.applet.*;


public class xyz extends Applet {
    public void init() {

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











