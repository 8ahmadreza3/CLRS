package S06_GraphAlgorithms.Chapter25;
import java.util.Arrays;

public class Johnson {
    static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = 0;
        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    static void dijkstraAlgorithm(int[][] graph, int[][] alteredGraph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true ;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + alteredGraph[u][v] < dist[v]) {
                    dist[v] = dist[u] + alteredGraph[u][v];
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + ": " + (dist[i] == Integer.MAX_VALUE ? "INFINITE" : dist[i]));
        }
    }

    static int[] bellmanFordAlgorithm(int[][] edges, int V) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[V] = 0;

        int[][] edgesWithExtra = Arrays.copyOf(edges, edges.length + V);
        for (int i = 0; i < V; i++) {
            edgesWithExtra[edges.length + i] = new int[]{V, i, 0};
        }

        for (int i = 0; i < V; i++) {
            for (int[] edge : edgesWithExtra) {
                if (dist[edge[0]] != Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                }
            }
        }

        return Arrays.copyOf(dist, V);
    }

    static void johnsonAlgorithm(int[][] graph) {
        int V = graph.length;
        int[][] edges = new int[V * (V - 1) / 2][3];
        int index = 0;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges[index++] = new int[]{i, j, graph[i][j]};
                }
            }
        }

        int[] alteredWeights = bellmanFordAlgorithm(edges, V);
        int[][] alteredGraph = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    alteredGraph[i][j] = graph[i][j] + alteredWeights[i] - alteredWeights[j];
                }
            }
        }

        for (int[] row : alteredGraph) {
            for (int weight : row) {
                System.out.print(weight + " ");
            }
        }

        for (int source = 0; source < V; source++) {
            dijkstraAlgorithm(graph, alteredGraph, source);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 4, 5},
                {0, 0, -1, 3},
                {0, 0, 0, 5},
                {0, 0, 0, 0}
        };

        johnsonAlgorithm(graph);
    }
}
