// package Recursion.Backtracking;

public class Nqueens {
    public static void main(String[] args) {
        int n=8;
        boolean[][] maze=new boolean[n][n];
        System.out.println(queens(maze, 0));
    }
    static int queens(boolean[][] board,int r)
    {
        if(r==board.length)
        {
            displayBoard(board);
            return 1;
        }
        int count=0;
        for(int col=0;col<board[0].length;col++)
        {
            if(isQueenSafe(r, col, board))
            {
                board[r][col]=true;
                count+=queens(board, r+1);
                board[r][col]=false;
            }
        }
        return count;
    }
    static void displayBoard(boolean[][] board)
    {
        for(boolean[] row:board)
        {
            for (boolean ele : row) {
                if(ele)
                {
                    System.out.print("Q");
                }
                else{
                    System.out.print("x");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean isQueenSafe(int r,int c,boolean[][] board){
        //check for vertical rows
        for(int i=0;i<r;i++)
        {
            if(board[i][c])
            {
                return false;
            }
        }
        //check for left diagonal
        int maxLeft=Math.min(r,c);
        for (int i = 1; i <=maxLeft; i++) {
            if(board[r-i][c-i])
            {
                return false;
            }
        }
        //check for right diagonal
        int maxRight=Math.min(r,board.length-1-c);
        for (int i = 1; i <= maxRight; i++) {
            if(board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
}
