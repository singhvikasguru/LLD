import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class RareEarth {
    static class Pair
    {
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x=x;this.y=y;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1}
        };
        Scanner sc= new Scanner(System.in);
        int re=sc.nextInt();
        Pair rareEarths[]= new Pair[re];
        for(int i=0;i<re;i++)
        {
            int x= sc.nextInt();
            int y=sc.nextInt();
            rareEarths[i]= new Pair(x, y);
        }
        int distance[][]= new int[grid.length][grid[0].length];
        boolean visited[][]= new boolean[grid.length][grid[0].length];
        for(int[] i:distance)
            Arrays.fill(i, Integer.MAX_VALUE);
        for(int i=0;i<re;i++)
        {
            dfs(distance, grid, visited, rareEarths[i].x, rareEarths[i].y, rareEarths[i].x, rareEarths[i].y, 0);
            for (boolean[] v:visited)
                Arrays.fill(v, false);
        }
        for (int i=0;i< distance.length;i++)
        {
            for (int j=0;j<distance[0].length;j++)
                System.out.print(distance[i][j]+" ");
            System.out.println();
        }
    }
    public static void dfs(int distance[][], int grid[][], boolean visited[][], int xtgt, int ytgt, int x, int y, int dis)
    {
        if(x<0||x>=grid.length||y<0||y>=grid[0].length)
            return;
        if(grid[x][y]==1 && visited[x][y]==false)
        {
            visited[x][y]=true;
//            int dist=Math.abs(x-xtgt)+Math.abs(y-ytgt);
            distance[x][y]=Math.min(distance[x][y], dis);
            dfs(distance, grid, visited, xtgt, ytgt, x-1, y, dis+1);
            dfs(distance, grid, visited, xtgt, ytgt, x, y-1, dis+1);
            dfs(distance, grid, visited, xtgt, ytgt, x, y+1, dis+1);
            dfs(distance, grid, visited, xtgt, ytgt, x+1, y, dis+1);
            visited[x][y]=false;
        }
    }
}
