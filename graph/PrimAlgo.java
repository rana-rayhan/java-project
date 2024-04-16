package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgo {
    public static class Edge {
        int src, dest, cost;

        Edge(int s, int d, int c) {
            this.src = s;
            this.dest = d;
            this.cost = c;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair> {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void primeAlgo(ArrayList<Edge>[] graph, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, 0));
        boolean[] vis = new boolean[V];

        int finalCost = 0;
        ArrayList<Integer> costList = new ArrayList<Integer>();

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;
                finalCost += curr.cost;
                costList.add(curr.cost);

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.cost));
                    }
                }
            }
        }
        System.out.print("MST cost list: ");
        for (int n : costList) {
            System.out.print(n + " ");
        }
        System.out.println("\nMST cost: " + finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        primeAlgo(graph, V);

    }
}
