package com.erick.company.graphs.representgraphs;

public class AdjacentMatrix {

    public static void main(String[] args) {
        /*
        1. Adjacency Matrix
Use a 2D array (V x V) where matrix[i][j] = 1 (or weight) if there is an edge from vertex i to vertex j, otherwise 0.

Works for directed and undirected graphs.

Good if the graph is dense (lots of edges).
         */

        /*
         Vertices = {A, B, C}

          | A | B | C
            A | 0 | 1 | 1
            B | 1 | 0 | 0
            C | 1 | 0 | 0
         */

        int[][] graph = new int[3][3];

        // A = 0, B = 1, C = 2
        graph[0][1] = 1; // A-B
        graph[1][0] = 1; // B-A (because undirected)
        graph[0][2] = 1; // A-C
        graph[2][0] = 1; // C-A

        //Easy to check if an edge exists: O(1) time.

        //⚡ Cons:
        //Takes O(V²) space even if very few edges.



        //Adjacent list


    }
}
