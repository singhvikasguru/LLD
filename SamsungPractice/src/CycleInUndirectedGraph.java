import java.util.*;

public class CycleInUndirectedGraph {

    public static void addEdge(int mat[][], int u, int v) {
        mat[u][v] = 1;
        mat[v][u] = 1;
    }

    public static boolean BFS(int mat[][], int s, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>(); // Pair of (vertex, parent)
        queue.add(new int[]{s, -1});

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int vertex = pair[0];
            int parent = pair[1];

            if (!visited[vertex]) {
                visited[vertex] = true;
                for (int i = 0; i < mat.length; i++) {
                    if (mat[vertex][i] == 1) { // Check edges of the current vertex
                        if (!visited[i]) {
                            queue.add(new int[]{i, vertex});
                        } else if (i != parent) { // Cycle detected
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int mat[][] = new int[V][V];
        addEdge(mat, 0, 1);
        addEdge(mat, 1, 3);
        addEdge(mat, 2, 1);
        addEdge(mat, 3, 2);

        boolean visited[] = new boolean[V];
        boolean flag = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (BFS(mat, i, visited)) {
                    flag = true;
                    System.out.println("Cycle found");
                    break; // No need to continue once a cycle is found
                }
            }
        }

        if (!flag) {
            System.out.println("No Cycle found");
        }
    }
}
