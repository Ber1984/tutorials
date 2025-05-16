package com.erick.company.graphs.graph.components;


import java.util.*;

/*
The idea:

Visit an unvisited node.

Do DFS/BFS to find and mark all reachable nodes — they form one connected component.

Repeat for unvisited nodes.

A single node with no edges can be a connected component

 Rule of Thumb
If you declare N nodes but only connect some of them:

Every unconnected node becomes a singleton component.
 */
public class ConnectedComponents {
    private int V;
    private List<List<Integer>> adj;

    public ConnectedComponents(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);  // undirected
    }

    private void dfs(int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }

    public List<List<Integer>> getConnectedComponents() {
        boolean[] visited = new boolean[V];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    public static void main(String[] args) {
        ConnectedComponents g = new ConnectedComponents(6); // total 6 nodes: 0 to 5

        g.addEdge(0, 1); // component 1
        g.addEdge(2, 3);  // component 2 (starts forming)
        g.addEdge(3, 4);  // component 2 (continues)

        List<List<Integer>> components = g.getConnectedComponents();

        System.out.println("Connected Components:");
        for (List<Integer> comp : components) {
            System.out.println(comp);
        }

        /*
        [0, 1]       // connected via edge (0,1)
        [2, 3, 4]    // connected via edges (2,3), (3,4)
        [5]          // exists, but no connections = its own component
         */
    }
}
