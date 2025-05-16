package com.erick.company.graphs.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    private int V; //Node
    private List<List<Edge>> adj; //neighbors

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Constructor
    public WeightedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an edge
    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Edge(v, weight));
        adj.get(v).add(new Edge(u, weight)); // if undirected
    }

    // Print the graph
    public void printGraph() {
        for (int u = 0; u < V; u++) {
            System.out.print("Node " + u + " connects to: ");
            for (Edge e : adj.get(u)) {
                System.out.print("(Node " + e.to + ", Weight " + e.weight + ") ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       /*
        ✅ In a weighted graph, each edge has a weight (or cost) associated with it.

Instead of just "there is an edge" (like in an unweighted graph),

Now "there is an edge with a specific cost/weight."

✅ Example:
Imagine cities connected by roads.

Node = City

Edge = Road

Weight = Distance (km) or Time (hours) or Cost ($)
        */


       //For weighted graphs, you can't just store the neighbor — you must also store the weight.

        List<List<Edge>> adj; //adjacents or neighbor
        //First Integer = neighbor node
        //Second Integer = weight of the edge

        WeightedGraph g = new WeightedGraph(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 4, 7);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 1);

        g.printGraph();

        //In weighted graphs.
        //BFS is NOT ideal for shortest path.
        //Instead, Dijkstra’s Algorithm is the standard for shortest path (because it considers weights).


    }
}



