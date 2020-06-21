package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Graph {
    private final int[][] graph;
    private final int V;

    public Graph(int V) {
        this.V = V;
        graph = new int[V][V];
    }

    public void addEdge(int v, int w) {
        graph[v][w] = graph[w][v] = 1;
    }

    public List<Integer> adj(int v) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, this.V).forEach(w -> {
            if (graph[v][w] == 1)
                list.add(w);
        });
        return list;
    }

    public int E() {
        final int[] edge = {0};
        IntStream.range(0, this.V).forEach(i -> IntStream.range(i + 1, this.V).forEach(j -> {
            if (graph[i][j] == 1)
                edge[0]++;
        }));
        return edge[0];
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
        Graph graph = new Graph(5);
        graph.addEdge(0, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.adj(3).forEach(System.out::println);
        System.out.println(graph.toString());
    }
}
