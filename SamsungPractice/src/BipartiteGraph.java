import java.util.Arrays;

public class BipartiteGraph {

    public static void addEdge(int mat[][], int u, int v) {
        mat[u][v] = 1;
        mat[v][u] = 1;
    }

    public static boolean DFS(int mat[][], int colors[], int color, int v)
    {
        if(colors[v]!=-1 && colors[v]!=color)
            return false;
        if(colors[v]==color)
            return true;
        colors[v]=color;
        color= color==0?1:0;

        for(int i=0;i<mat.length;i++)
        {
            if(mat[v][i]==1)
            {
                boolean result= DFS(mat, colors, color, i);
                if(result==false)
                    return false;
            }
        }
        return true;

    }
    public static void main(String args[])
    {
        int V=4;
        int mat[][] = new int[V][V];
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 3);
        addEdge(mat, 2, 1);
        addEdge(mat, 0, 2);

        int colors[]= new int[V];
        boolean flag=false;
        Arrays.fill(colors, -1);

        for(int i=0;i<V;i++)
        {
            if(colors[i]==-1)
                if (!DFS(mat, colors,0, i)) {
                    flag = true;
                    System.out.println("Graph is not bipartite");
                    break; // No need to continue once a cycle is found
                }
        }
        if(!flag)
            System.out.println("Graph is bipartite");

    }
}
