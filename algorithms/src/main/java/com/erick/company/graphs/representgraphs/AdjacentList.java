package com.erick.company.graphs.representgraphs;

import java.util.*;

public class AdjacentList {

    public static void main(String[] args) {
        /*
         Adjacency List
        For each node, maintain a list (or set) of its neighbors.

        Very efficient for sparse graphs.
         */

        //A --- B
        //|
        //C

        //A -> [B, C]
        //B -> [A]
        //C -> [A]

        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A"));
        graph.put("C", Arrays.asList("A"));

        //Integer nodes
        List<List<Integer>> graph1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            graph1.add(new ArrayList<>());
        }
        graph1.get(0).add(1); // A-B
        graph1.get(0).add(2); // A-C
        graph1.get(1).add(0); // B-A
        graph1.get(2).add(0); // C-A

        /*
        ⚡ Pros:

        Very space efficient: O(V + E)
        Easy to iterate over neighbors.

        ⚡ Cons:

        Checking if a specific edge exists can be slower (O(k), where k = number of neighbors).
         */


    }
}
