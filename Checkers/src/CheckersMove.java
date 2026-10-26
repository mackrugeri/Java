
public class CheckersMove {
    
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
