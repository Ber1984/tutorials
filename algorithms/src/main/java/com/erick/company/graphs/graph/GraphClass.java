package com.erick.company.graphs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphClass {
    public static void main(String[] args) {
        GraphClass g = new GraphClass(5); // 5 nodes: 0, 1, 2, 3, 4

        g.addEdge(0, 1); //When calling addEdge(0, 1), it means "connect node 0 and node 1."
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();


        g.dfs(0); // Start DFS from node 0
        g.bfs(0); // Start BFS from node 0
    }

    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list

    // Constructor
    public GraphClass(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an edge (undirected) set of edges - relationship
    public void addEdge(int u, int v) {
        /*
        u and v are integers representing the two nodes connected by an edge.
        When calling addEdge(0, 1), it means "connect node 0 and node 1."
        Since this is an undirected graph, we add both adj.get(u).add(v); and adj.get(v).add(u);, so the connection works both ways.
        */


        //U means a node
        adj.get(u).add(v);
        adj.get(v).add(u); // For undirected graphs
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + " connects to: ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }


    /*
    Here, u is:

    The current node we are visiting.
     We mark u as visited (visited[u] = true;).
     Then, we visit all its neighbors (v).

        When dfsUtil(0, visited); is called:

        It prints 0 first.

        Then calls itself recursively on all neighbors of 0.
     */
    //Depth-First Search (DFS) — Traverse recursively
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        dfsUtil(start, visited);
    }

    private void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    //Breadth-First Search (BFS) — Traverse level by level
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll(); // Get the current node
            System.out.print(u + " ");

            for (int v : adj.get(u)) { // Go through all neighbors
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        /*
        u is the current node being processed.
        v represents its neighbors.
         */
    }


}
