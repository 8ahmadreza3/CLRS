package S06_GraphAlgorithms.Chapter24;

import java.util.*;

class SingleSourceShortestPaths {
    List<List<Pair>> adj;
    int V, E;
    Edge[] edge;
    Vector<Pair>[] graph = new Vector[100000];


    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    SingleSourceShortestPaths(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<Pair>();
        }
    }

    SingleSourceShortestPaths(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void addEdge(int u, int v, int w ) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
        graph[u].add(new Pair(v, w));
    }

    void shortestPath(int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.second));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (Pair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new Pair(dist[v.first], v.first));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + "   " + dist[i]);
        }
    }

    int minDistance(int[] dist, Boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int[] dist) {
        for (int i = 0; i < V; i++)
            System.out.println(i + " ==> " + dist[i]);
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        Boolean[] sptSet = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist);
    }

    static class Edge {
        int src, dest, weight;
        public Edge() {
            src = dest = weight = 0;
        }
    }

    void BellmanFord(int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }
        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, V);
    }

    void printArr(int[] dist, int V) {
        for (int i = 0; i < V; ++i)
            System.out.println(i + "   " + dist[i]);
    }

    void shortestPathFaster(int S, int V) {
        int []d = new int[V + 1];
        boolean []inQueue = new boolean[V + 1];

        for (int i = 0; i <= V; i++)
            d[i] = Integer.MAX_VALUE;

        d[S] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        inQueue[S] = true;

        while (!q.isEmpty()) {
            int u = q.peek();
            q.remove();
            inQueue[u] = false;
            for (int i = 0; i < graph[u].size(); i++) {
                int v = this.graph[u].get(i).first;
                int weight = graph[u].get(i).second;
                if (d[v] > d[u] + weight) {
                    d[v] = d[u] + weight;
                    if (!inQueue[v]) {
                        q.add(v);
                        inQueue[v] = true;
                    }
                }
            }
        }

        printArr(d, V);
    }

    public static void main(String[] args) {
        int v = 5;
        int se = 1;
        SingleSourceShortestPaths s = new SingleSourceShortestPaths(v, se);

        s.addEdge(1, 2, 1);
        s.addEdge(2, 3, 7);
        s.addEdge(1, 4, 9);
        s.addEdge(2, 4, -2);
        s.addEdge(3, 4, 3);
        s.addEdge(1, 3, 8);
        s.addEdge(2, 5, 3);
        s.addEdge(4, 5, -3);
        s.shortestPathFaster(se, v);
    }
}
