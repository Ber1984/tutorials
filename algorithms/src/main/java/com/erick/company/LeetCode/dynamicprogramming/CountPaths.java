package com.erick.company.LeetCode.dynamicprogramming;

import java.util.*;

public class CountPaths {

    public static void main(String[] args) {
        System.out.println(countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }

    public static int countPaths(int n, int[][] roads) {
        // Graph adjacency list representation
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Dijkstra's Algorithm
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // {dist, node}

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int) top[1];

            if (d > dist[u]) continue; // Ignore outdated distances

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                long newDist = d + neighbor[1];

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u]; // Reset ways to reach v
                    pq.offer(new long[]{newDist, v});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1]; // Ways to reach the last node
    }
}
