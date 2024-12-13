import java.util.*;

public class RareEarthBFS {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1}
        };
        Scanner sc = new Scanner(System.in);
        int re = sc.nextInt();
        Pair rareEarths[] = new Pair[re];
        for (int i = 0; i < re; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            rareEarths[i] = new Pair(x, y);
        }

        int distance[][] = new int[grid.length][grid[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (Pair rareEarth : rareEarths) {
            bfs(distance, grid, rareEarth.x, rareEarth.y);
        }

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++)
                System.out.print(distance[i][j] + " ");
            System.out.println();
        }
    }

    public static void bfs(int[][] distance, int[][] grid, int startX, int startY) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY));
        visited[startX][startY] = true;
        distance[startX][startY] = 0;

        int[] dx = {-1, 1, 0, 0}; // Movement in four directions
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int x = current.x, y = current.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                        && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Pair(newX, newY));
                    distance[newX][newY] = Math.min(distance[newX][newY], distance[x][y] + 1);
                }
            }
        }
    }
}
