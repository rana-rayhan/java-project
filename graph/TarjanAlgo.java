package graph;

import java.util.ArrayList;

public class TarjanAlgo {
    public static class Edge {
        int src, dist;

        Edge(int s, int d) {
            this.src = s;
            this.dist = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // tarjan algo | dfs
    public static void tarjanAlgo(ArrayList<Edge>[] graph, boolean[] vis, int[] dt, int[] low, int time, int curr, int parent) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dist == parent) {
                continue;
            } else if (!vis[e.dist]) {
                tarjanAlgo(graph, vis, dt, low, time, e.dist, e.src);
                low[curr] = Math.min(low[curr], low[e.dist]);
                if (dt[curr] < low[e.dist]) {
                    System.out.println("Bridge is: " + curr + "----" + e.dist);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dist]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge>[] graph, int v) {
        int[] dt = new int[v];
        int[] low = new int[v];
        int time = 0;
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                tarjanAlgo(graph, vis, dt, low, time, i, -1);
            }
        }

    }

    public static class demo {
        public void Print(int x, String s) {
            System.out.println("An integer: " + x + " and a string: " + s);
        }
        public void Print(String s, int x) {
            System.out.println("A string: " + s + " and an integer: " + x);
            Print(1, "one");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph, v);
        getBridge(graph, v);

        demo d = new demo();
        d.Print(1,"one");
    }
}
