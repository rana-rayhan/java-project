package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public static class Edge {
        int src;
        int dist;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dist = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dest) {
            this.node = node;
            this.dist = dest;
        }

        @Override
        public int compareTo(Pair P) {
            return this.dist - P.dist;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dest = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dest[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[V];

        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int src1 = e.src;
                    int dest1 = e.dist;

                    if (dest[src1] + e.wt < dest[dest1]) {
                        dest[dest1] = dest[src1] + e.wt;
                        pq.add(new Pair(dest1, dest[dest1]));
                    }
                }
            }
        }
        for (int n : dest) {
            System.out.print(n + " ");
        }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src, int V) {
        int[] dest = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dest[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dist;

                    if (dest[u] != Integer.MAX_VALUE && dest[u] + e.wt < dest[v]) {
                        dest[v] = dest[u] + e.wt;
                    }
                }
            }
        }

        for (int n : dest) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        dijkstra(graph, 0, V);
    }
}
