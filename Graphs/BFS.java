package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS{
    public static List<List<Integer>> createAdjacencyList(){
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
    
    public static void printGraph(List<List<Integer>> graph) {
        System.out.println(graph.toString());
    }
    public static void bfsTraversal(List<List<Integer>> graph){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[graph.size()];
        Arrays.fill(visited, false);
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int node=q.poll();
            list.add(node);
            for(int it:graph.get(node))
            {
                if(visited[it]==false){
                    q.add(it);
                    visited[it]=true;
                }
            }
        }
        System.out.println(list.toString());
    }
    public static void main(String[] args) {
        List<List<Integer>> graph = createAdjacencyList();
        printGraph(graph);
        System.out.println();
        bfsTraversal(graph);
    }

}
