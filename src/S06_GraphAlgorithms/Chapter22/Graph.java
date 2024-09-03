package S06_GraphAlgorithms.Chapter22;

import java.util.*;

public class Graph {
    int V;
    static int WHITE = 0, GRAY = 1, BLACK = 2;
    List<Integer>[] adjList;
    String[] color;
    int[] d, p;

    public Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<Integer>();
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    void BFSSingleSource(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        d[s] = 0;
        color[s] = "green";
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (Object index : adjList[u]) {
                int i = (int) index ;
                if (Objects.equals(color[i], "white")) {
                    color[i] = "green";
                    d[i] = d[u] + 1;
                    p[i] = u;
                    q.add(i);
                }
            }
            color[u] = "dark_green";
        }
        System.out.println();
    }

    void BFSFull(int n) {
        color = new String[n];
        d = new int[n];
        p = new int[n];
        Arrays.fill(color, "white");
        Arrays.fill(d, 0);
        Arrays.fill(p, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == "white")
                BFSSingleSource(i);
        }
    }

    boolean DFSUtil(int u, int[] color) {
        color[u] = GRAY;
        for (Integer in : adjList[u]) {
            if (color[in] == GRAY)
                return true;

            if (color[in] == WHITE && DFSUtil(in, color))
                return true;
        }

        color[u] = BLACK;
        return false;
    }

    boolean isCyclic(Graph g) {
        int[] color = new int[g.V];
        for (int i = 0; i < g.V; i++) {
            color[i] = WHITE;
        }
        for (int i = 0; i < g.V; i++) {
            if (color[i] == WHITE)
                if(DFSUtil(i, color))
                    return true;
        }
        return false;
    }

    void DFSRec(boolean[] visited, int s){
        visited[s] = true;
        System.out.print(s + " ");

        for (int i : adjList[s]) {
            if (!visited[i])
                DFSRec(visited, i);
        }
    }

    void DFS(int s) {
        boolean[] visited = new boolean[adjList.length];
        DFSRec(visited, s);
    }
}

