package com.erick.company.graphs.graph.exercises;

import java.util.*;

public class ShortestPathErickVersion {
}

class DijkstraGraph {
    private int V; //Number of nodes in the graph remember vertex is the current node
    private List<List<Edge>> adj; //Edges with his neighbor for example connection

    static class Edge {
        int to, weight; //distance between current node to another node

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public DijkstraGraph(int V) {//when i added the number of nodes in my graph i'll create a list of adjacents
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Directed edge: u --> v with weight  u will be my node and how it connects to another node
    public void addEdge(int u, int v, int weight) {
        //u = node , v = connection to another node , w is the distance in this nodes
        adj.get(u).add(new Edge(v, weight));
    }

    // Dijkstra from source or start
    //It is the starting point in the graph for Dijkstra’s algorithm - You're finding the shortest paths from this node to every other node in the graph.
    public int[] dijkstra(int src) {
        int[] finalDist = new int[V];//create an array of nodes
        Arrays.fill(finalDist, Integer.MAX_VALUE);//fill this array with infinitive values
        finalDist[src] = 0; //finalDist[0] = 0 because the distance from the source to itself is always 0

        // Min-heap based on distance

        /*
         In this case, each element in the queue is an int[], i.e., an array with two elements:
         a[0]: the node ID
         a[1]: the distance from the source
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //“Compare arrays by their second element (a[1]), which represents the distance.”
        /*
        So: If you insert {1, 5}, {2, 3}, and {4, 10},
        It will sort them by the distance values: 3, 5, and 10.
         */

        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0]; //node
            int d = curr[1]; //edge or distance

            if (d > finalDist[u]) continue; // Already found a better path

            for (Edge edge : adj.get(u)) {
                int v = edge.to;//vertex
                int weight = edge.weight;

                if (finalDist[u] + weight < finalDist[v]) {
                    finalDist[v] = finalDist[u] + weight;
                    pq.offer(new int[]{v, finalDist[v]});
                }
            }
        }

        return finalDist;
    }

    public static void main(String[] args) {
        DijkstraGraph g = new DijkstraGraph(5); //graph with 5 nodes

        g.addEdge(0, 1, 5); // 0 -> 1 : 5
        g.addEdge(0, 2, 2); // 0 -> 2 : 2
        g.addEdge(1, 2, 1); // 1 -> 2 : 1
        g.addEdge(1, 3, 3); // 1 -> 3 : 3
        g.addEdge(2, 3, 6); // 2 -> 3 : 6

        int[] distances = g.dijkstra(0);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " = " + distances[i]);
        }
    }
}

