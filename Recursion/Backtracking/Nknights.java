// package Recursion.Backtracking;

public class Nknights {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[4][4];
        knights(n, board, 0, 0);
    }
    static void knights(int noOfK,boolean[][] board,int r,int c)
    {
        if(noOfK==0)
        {
            displayBoard(board);
            System.out.println();
            return ;
        }

        //when program reaches the last cell just return the control of the program
        if(r==board.length-1 && c==board.length-1)
        {
            return;
        }

        //move to next row after reaching end of row
        if(c==board.length)
        {
            //move to next row
            knights(noOfK, board, r+1, 0);
            return;
        }
        if(isKnightSafe(board,r,c))
        {
            board[r][c]=true;
            knights(noOfK-1, board, r, c+1);
            board[r][c]=false;
        }
        knights(noOfK, board, r, c+1);
        return;

    }
    static boolean isKnightSafe(boolean[][] board, int r, int c) {
        if(isValid(board, r-1, c+2))
        {
            if(board[r][c])
            {
                return false;
            }
        }
        if(isValid(board, r-1, c-2))
        {
            if(board[r][c])
            {
                return false;
            }
        }
        if(isValid(board, r+2, c-1))
        {
            if(board[r][c])
            {
                return false;
            }
        }
        if(isValid(board, r+2, c+1))
        {
            if(board[r][c])
            {
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][] board, int r, int c)
    {
        if(r>=0 && r<board.length && c>=0 && c<board.length)
        {
            return true;
        }
        return false;
    }
    static void displayBoard(boolean[][] board)
    {
        for(boolean[] row:board)
        {
            for (boolean ele : row) {
                if(ele)
                {
                    System.out.print("K");
                }
                else{
                    System.out.print("x");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
