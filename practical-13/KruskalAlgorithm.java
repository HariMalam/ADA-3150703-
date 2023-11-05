import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class KruskalAlgorithm {
    private int V, E; // V - number of vertices, E - number of edges
    private Edge[] edges; // Array to store all edges in the graph

    public KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(0, 0, 0);
        }
    }

    // Helper function to find the parent of a set (used in union-find)
    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    // Helper function to perform union of two sets (used in union-find)
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V]; // Array to store the result (minimum spanning tree)
        int e = 0; // Index variable for result[]

        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight)); // Sort edges by weight

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        int i = 0;
        while (e < V - 1 && i < E) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the minimum spanning tree:");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges
        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        graph.kruskalMST();
    }
}
