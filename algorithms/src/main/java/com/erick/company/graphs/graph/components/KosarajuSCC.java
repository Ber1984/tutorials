package com.erick.company.graphs.graph.components;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 Kosaraju’s Algorithm Steps:
DFS to fill a stack with vertices in finishing order.
Transpose the graph (reverse the edges).
DFS again on the transposed graph, in the order defined by the stack — each DFS traversal gives one SCC.
 */
public class KosarajuSCC {

    private final int V; // Number of vertices or nodes
    private final List<List<Integer>> adj;

    public KosarajuSCC(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v); // Directed edge because we're working with a directed graph
    }

    // Step 1: Fill stack with finish times (postorder)
    private void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor])
                fillOrder(neighbor, visited, stack);
        }
        stack.push(v); // All descendants done
    }

    // Step 2: Transpose the graph (reverse all edges)
    private List<List<Integer>> getTranspose() {
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            transpose.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                transpose.get(v).add(u); // reverse direction
            }
        }

        return transpose;
    }

    // Step 3: DFS on transposed graph
    private void dfs(int v, boolean[] visited, List<List<Integer>> transpose, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int neighbor : transpose.get(v)) {
            if (!visited[neighbor])
                dfs(neighbor, visited, transpose, component);
        }
    }

    // Main method to find all SCCs
    public List<List<Integer>> getSCCs() {
        Stack<Integer> stack = new Stack<>(); //LIFO
        boolean[] visited = new boolean[V];

        // Fill stack by finish time
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                fillOrder(i, visited, stack);
        }

        // Transpose the graph
        List<List<Integer>> transpose = getTranspose();

        // Reset visited array for second DFS
        Arrays.fill(visited, false);

        // Second DFS based on stack order
        List<List<Integer>> sccs = new ArrayList<>();

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs(node, visited, transpose, component);
                sccs.add(component);
            }
        }

        return sccs;
    }

    // Test case
    public static void main(String[] args) {
        KosarajuSCC graph = new KosarajuSCC(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);

        List<List<Integer>> sccs = graph.getSCCs();

        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }
}
