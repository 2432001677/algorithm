package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Digraph {
    private final int[][] graph;
    private final int V;
    private final boolean[] marked;

    public Digraph(int V) {
        this.V = V;
        graph = new int[V][V];
        marked = new boolean[V];
    }

    public void addEdge(int v, int w) {
        graph[v][w] = 1;
    }

    public List<Integer> adj(int v) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, this.V)
                .forEach(w -> {
                    if (graph[v][w] == 1 || graph[w][v] == 1)
                        list.add(w);
                });
        return list;
    }

    public int E() {
        final int[] edge = {0};
        IntStream.range(0, this.V)
                .forEach(i -> IntStream.range(0, this.V).forEach(j -> {
                            if (graph[i][j] == 1 && i != j)
                                edge[0]++;
                        })
                );
        return edge[0];
    }

    private int nextNode(int v) {
        for (int i = 0; i < this.V; i++)
                if (!marked[i] && graph[v][i] == 1 && v != i)
                    return i;
        return -1;
    }

    public void dfs() {
        for (int i = 0; i < this.V; i++)
            marked[i] = false;
        dfs(0);
    }

    private void dfs(int v) {
        System.out.println(v);
        marked[v] = true;
        int next = nextNode(v);
        if (next != -1)
            dfs(next);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int[] arr : graph) {
            for (int s : arr)
                string.append(s).append(" ");
            string.append('\n');
        }
        return string.toString();
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(5);
        graph.addEdge(0, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(4, 2);
        graph.adj(3).forEach(System.out::println);
        System.out.println(graph.E());
        System.out.println(graph.toString());
        graph.dfs();
    }
}
