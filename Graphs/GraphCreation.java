package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphCreation {
    public List<List<Integer>> createAdjacencyList(){
        Scanner sc=new Scanner(System.in);
        List<List<Integer>> graph=new ArrayList<>();
        System.out.println("Enter number of nodes");
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            List<Integer> temp=new ArrayList<>();
            System.out.print("Enter number of edges for node"+i+"-->");
            int E=sc.nextInt();
            System.out.println("Enter adjacent nodes for node"+i);
            for(int j=0;j<E;j++){
                int val=sc.nextInt();
                temp.add(val);
            }
            graph.add(temp);
        }
        sc.close();
        return graph;
    }
    public  int[][] createAdjacencyMatrix(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int N = sc.nextInt();
        int[][] graph=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                graph[i][j]=sc.nextInt();
            }
        }
        sc.close();
        return graph;
    }
    public  void printGraph(List<List<Integer>> graph){
        System.out.println(graph.toString());
    }
}
