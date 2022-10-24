package com.erick.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 It's data structure to connect multiples points to each other
 Use vertices and edges to connect
 The examples of graph are a social media network, computer network, Google Maps, etc.
 Each graph consists of edges and vertices (also called nodes). Each vertex and edge have a relation. Where vertex represents the data and edge represents the relation between them. Vertex is denoted by a circle with a label on them. Edges are denoted by a line that connects nodes (vertices).
 Vertex: Vertices are the point that joints edges. It represents the data. It is also known as a node.
 Edge: An edge is a line that connects two vertices. It represents the relation between the vertices. Edges are denoted by a line. For example, a path to the bus stop from your house.

 */
public class Graph<T> {

    //creating an object of the Map class that stores the edges of the graph
    private Map<T, List<T>> map = new HashMap<>();

    //adding new node = data
    public void addNewVertex(T s) {
        map.put(s, new LinkedList<T>());
    }

    //the method adds an edge between source and destination
    public void addNewEdge(T source, T destination, boolean bidirectional) {
//
        if (!map.containsKey(source))
            addNewVertex(source);
        if (!map.containsKey(destination))
            addNewVertex(destination);
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    //the method counts the number of vertices
    public void countVertices() {
        System.out.println("Total number of vertices: " + map.keySet().size());
    }

    public void countEdges(boolean bidirection) {
//variable to store number of edges
        int count = 0;
        for (T v : map.keySet()) {
            count = count + map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("Total number of edges: " + count);
    }

    //checks a graph has vertex or not
    public void containsVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    //checks a graph has edge or not
//where s and d are the two parameters that represent source(vertex) and destination (vertex)
    public void containsEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else {
            System.out.println("There is no edge between " + s + " and " + d + ".");
        }
    }

    //prints the adjacencyS list of each vertex
//here we have overridden the toString() method of the StringBuilder class
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//foreach loop that iterates over the keys
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
//foreach loop for getting the vertices
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }


}

class GraphImplementation {
    public static void main(String[] args) {

        //creating an object of the Graph class
        var graph = new Graph<Integer>();

        //adding edges to the graph
        graph.addNewEdge(0, 1, true);
        graph.addNewEdge(0, 4, true);
        graph.addNewEdge(1, 2, true);
        graph.addNewEdge(1, 3, false);
        graph.addNewEdge(1, 4, true);
        graph.addNewEdge(2, 3, true);
        graph.addNewEdge(2, 4, true);
        graph.addNewEdge(3, 0, true);
        graph.addNewEdge(2, 0, true);
//prints the adjacency matrix that represents the graph
        System.out.println("Adjacency List for the graph:\n" + graph.toString());
//counts the number of vertices in the graph
        graph.countVertices();
//counts the number of edges in the graph
        graph.countEdges(true);
//checks whether an edge is present or not between the two specified vertices
        graph.containsEdge(3, 4);
        graph.containsEdge(2, 4);
//checks whether vertex is present or not
        graph.containsVertex(3);
        graph.containsVertex(5);
    }
}