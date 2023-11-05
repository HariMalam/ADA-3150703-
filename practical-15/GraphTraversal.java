import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // Depth-First Search (DFS)
    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");

            for (int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    // Breadth-First Search (BFS)
    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}

public class GraphTraversal {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Depth-First Search (DFS):");
        graph.DFS(0);

        System.out.println("\n\nBreadth-First Search (BFS):");
        graph.BFS(0);
    }
}
