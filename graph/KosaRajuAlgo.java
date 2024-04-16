package graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosaRajuAlgo {
    public static class Edge {
        int src, dist;

        Edge(int s, int d) {
            this.src = s;
            this.dist = d;
        }
    }

    // creating graph
    public static void createGraph(ArrayList<Edge>[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    // top sort algo
    public static void topSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> stack, int curr) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dist]) {
                topSort(graph, vis, stack, e.dist);
            }
        }
        stack.push(curr);
    }

    // depth for search
    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dist]) {
                dfs(graph, vis, e.dist);
            }
        }
    }

    // Kosa raju's Algo
    public static void kosarajuAlgo(ArrayList<Edge>[] graph, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[v];
        // step 1: creating stack
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSort(graph, vis, stack, i);
            }
        }

        // step 2: create transpose and reverse the graph
        ArrayList<Edge>[] transpose = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dist].add(new Edge(e.dist, e.src));
            }
        }
        // step 3: printing scc
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!vis[curr]) {
                dfs(transpose, vis, curr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph, v);
        kosarajuAlgo(graph, v);
    }

}
