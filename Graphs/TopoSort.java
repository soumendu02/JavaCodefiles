
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] vis=new boolean[V];
        Arrays.fill(vis, false);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        toposort(adj, vis);

        KahnAlgo ka=new KahnAlgo();
        ka.topo(V, adj);
    }
    public static void toposort(List<List<Integer>> graph, boolean[] visited){
        Stack<Integer> st=new Stack<>();
       for (int i = 0; i < graph.size(); i++) {
        if(!visited[i])
         dfs(i, graph, visited, st);
       }
       int[] ans=new int[graph.size()];
       int j=0;
       while(!st.isEmpty()){
        ans[j++]=st.peek();
        st.pop();
       }
       System.out.println(Arrays.toString(ans));

    }
    public static void dfs(int node,List<List<Integer>> graph,boolean[] visited,Stack<Integer> stack){
        visited[node]=true;
        for(int adjNode:graph.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode,graph,visited,stack);
            }
        }
        stack.push(node);
    }
}

class KahnAlgo{
    public  void indegree(int[] indeg, List<List<Integer>> graph){
        for(int i=0;i<indeg.length;i++){
            for(int adjnode:graph.get(i)){
                indeg[adjnode]++;
            }
        }
    }
    public  void topo(int V,List<List<Integer>> graph){
        Queue<Integer> que=new LinkedList<>();
        int[] topoArray=new int[V];
        int[] indeg=new int[V];
        indegree(indeg, graph);
        for(int i=0;i<V;i++){
            if(indeg[i]==0)
                que.add(i);
        }
        int c=0;
        while (!que.isEmpty()) {
            int node=que.poll();
            topoArray[c++]=node;
            for(int adjnode:graph.get(node)){
                indeg[adjnode]--;
                if(indeg[adjnode]==0)
                    que.add(adjnode);
            }
        }
        System.out.println(Arrays.toString(topoArray));
    }
}