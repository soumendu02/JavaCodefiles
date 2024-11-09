package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class DFS {
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
    public static void dfsTraversal(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        ArrayList<Integer> lt=new ArrayList<>();
        dfs(graph, 0, visited, lt);
        System.out.println(lt.toString());
    }
    public static void dfs(List<List<Integer>> graph,int node,boolean[] visited, ArrayList<Integer> lt)
    {
        visited[node]=true;
        lt.add(node);
        for(int it:graph.get(node)){
            if(!visited[it])
                dfs(graph,it,visited,lt);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> graph = createAdjacencyList();
        printGraph(graph);
        System.out.println();
        dfsTraversal(graph);
    }
}
