package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDSA {
    static class Edge {
        int src;
        int dst;

        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 2));
    }

    public static void bfs(ArrayList<Edge>[] graph, boolean[] v, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!v[curr]) {
                System.out.print(curr + " ");
                v[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                dfs(graph, vis, e.dst);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, boolean[] vis, int curr, int tar, String path) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                vis[curr] = true;
                printAllPath(graph, vis, e.dst, tar, path + " " + e.dst);
                vis[curr] = false;
            }
        }
    }

    public static boolean isCycle(ArrayList<Edge>[] graph, boolean[] vis, boolean[] ruc, int curr) {
        vis[curr] = true;
        ruc[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (ruc[e.dst]) {
                return true;
            } else if (!vis[e.dst]) {
                if (isCycle(graph, vis, ruc, e.dst)) {
                    return true;
                }
            }
        }
        ruc[curr] = false;
        return false;
    }

    public static boolean isCycleUndirected(ArrayList<Edge>[] graph, int curr, int parent, boolean[] vis) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dst] && e.dst != parent) {
                return true;
            } else if (!vis[e.dst]) {
                if (isCycleUndirected(graph, e.dst, curr, vis)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isCycleDetected(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] rec) {
        vis[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dst]) {
                return true;
            } else if (!vis[e.dst]) {
                if (isCycleDetected(graph, e.dst, vis, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> stack, int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                topSortUtil(graph, vis, stack, e.dst);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean vis[] = new boolean[V];
        Stack<Integer> stacks = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(graph, vis, stacks, i);
            }
        }
        while (!stacks.isEmpty()) {
            System.out.print(stacks.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleUndirected(graph, 0, 0, new boolean[V]));
    }
}