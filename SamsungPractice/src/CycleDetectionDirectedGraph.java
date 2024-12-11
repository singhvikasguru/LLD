import java.util.Arrays;

public class CycleDetectionDirectedGraph {

    // Add a directed edge to the adjacency matrix
    public static void addEdge(int mat[][], int u, int v) {
        mat[u][v] = 1;
    }

    // Perform DFS to detect a cycle
    public static boolean DFS(int mat[][], int s, boolean[] visited, boolean[] recStack) {
        // If the current node is already in the recursion stack, a cycle is detected
        if (recStack[s]) {
            return true;
        }

        // Mark the current node as visited and add it to the recursion stack
        visited[s] = true;
        recStack[s] = true;
        System.out.println("Visiting node " + s + " : Recursion Stack = " + Arrays.toString(recStack));

        // Explore all adjacent vertices
        for (int i = 0; i < mat.length; i++) {
            if (mat[s][i] == 1) { // Check if there's an edge
                if (!visited[i] && DFS(mat, i, visited, recStack)) {
                    return true; // Cycle detected in a deeper call
                } else if (recStack[i]) {
                    return true; // Cycle detected via an already visited node
                }
            }
        }

        // Remove the current node from the recursion stack
        recStack[s] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] mat = new int[V][V];

        // Add directed edges
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 3);
        addEdge(mat, 1, 2);
        addEdge(mat, 2, 3);
        // Uncomment the line below to introduce a cycle
         addEdge(mat, 3, 0);

        // Initialize visited and recursion stack arrays
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        boolean flag = false;

        // Check for cycles in all components of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DFS(mat, i, visited, recStack)) {
                    System.out.println("Cycle found starting from node: " + i);
                    flag = true;
                    break; // No need to continue once a cycle is found
                }
            }
        }

        if (!flag) {
            System.out.println("No Cycle found");
        }
    }
}
