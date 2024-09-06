// package Recursion.Maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        boolean[][] maze={{true,true,true},
                        {true,true,true},
                        {true,true,true}};

        pathInAllDire("", maze, 0, 0);
        int[][] path=new int[maze.length][maze[0].length];
        printAllPaths("", maze, 0, 0, path, 1);
    }
    public static int countPaths(int r,int c)
    {
        if(r==1 || c==1)
        {
            return 1;
        }
        int down=countPaths(r-1, c);
        int right=countPaths(r, c-1);
        return down+right;
    }
    public static List<String> printPath(String p,int r,int c)
    {
        if(r==1 && c==1)
        {
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        if(r>1)
        {
            list.addAll(printPath(p+"D", r-1, c));
        }
        if(c>1)
        {
            list.addAll(printPath(p+"R", r, c-1));
        }
        return list;
    }
    static void pathRestrictions(String p,boolean[][] maze,int r,int c)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }
        if(r<maze.length-1)
        {
            pathRestrictions(p+'D', maze, r+1, c);
        }
        if(c<maze[0].length-1)
        {
            pathRestrictions(p+'R', maze, r, c+1);
        }
    }
    static void pathInAllDire(String p,boolean[][] maze,int r,int c)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if(!maze[r][c])
        {
            return;
        }
        maze[r][c]=false;
        if(r<maze.length-1)
        {
            pathInAllDire(p+'D', maze, r+1, c);
        }
        if(c<maze[0].length-1)
        {
            pathInAllDire(p+'R', maze, r, c+1);
        }
        if(r>0)
        {
            pathInAllDire(p+'U', maze, r-1, c);
        }
        if(c>0)
        {
            pathInAllDire(p+'L', maze, r, c-1);
        }
        maze[r][c]=true;
    }
    static void printAllPaths(String p,boolean[][] maze,int r,int c,int[][] path,int step)
    {
        if(r==maze.length-1 && c==maze[0].length-1)
        {
            path[r][c]=step;
            for (int[] is : path) {
                System.out.println(Arrays.toString(is));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c])
        {
            return;
        }
        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1)
        {
            printAllPaths(p+'D', maze, r+1, c,path,step+1);
        }
        if(c<maze[0].length-1)
        {
            printAllPaths(p+'R', maze, r, c+1,path,step+1);
        }
        if(r>0)
        {
            printAllPaths(p+'U', maze, r-1, c,path,step+1);
        }
        if(c>0)
        {
            printAllPaths(p+'L', maze, r, c-1,path,step+1);
        }
        maze[r][c]=true;
        path[r][c]=0;
    }
    
}
