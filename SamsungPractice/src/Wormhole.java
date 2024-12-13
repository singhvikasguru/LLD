import java.util.Arrays;
import java.util.Scanner;

public class Wormhole {
    static class Pair
    {
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    static void computeDistance(int distance[][], Pair coordinates[], int points)
    {
        for(int i=0;i<points;i++)
        {
            for (int j=0;j<points;j++)
            {
                if(distance[i][j]==-1)
                    distance[i][j]= Manhattan(coordinates[i], coordinates[j]);
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int Manhattan(Pair p1, Pair p2)
        {
            return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
        }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int points=2*n+2;
        Pair coordinates[]= new Pair[points];
        int distance[][]= new int[points][points];
        for(int i=0;i<points;i++)
            Arrays.fill(distance[i], -1);

//        System.out.println("Source coordinates: ");
        int x=sc.nextInt();
        int y=sc.nextInt();
        coordinates[0]= new Pair(x, y);

//        System.out.println("Destination coordinates: ");
        x=sc.nextInt();
        y=sc.nextInt();
        coordinates[points-1]= new Pair(x, y);

        int counter=1;
        for(int i=0;i<n;i++)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            coordinates[counter++]=new Pair(x, y);

            x=sc.nextInt();
            y=sc.nextInt();
            coordinates[counter++]=new Pair(x, y);

            distance[2*i+1][2*i+2]=sc.nextInt();
            distance[2*i+2][2*i+1]=distance[2*i+1][2*i+2];
        }

        computeDistance(distance, coordinates, points);

        boolean inSet[]= new boolean[points];
        int minDist[]= new int[points];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        findShortestPath(distance, inSet, minDist, points);

    }
    public static int findMinDistanceVertex(int minDist[], boolean inSet[])
    {
        int v=-1;
        int dis=Integer.MAX_VALUE;
        for(int i=0;i<minDist.length;i++)
        {
            if(inSet[i]==false)
            {
                if(dis>minDist[i])
                {
                    dis=minDist[i];
                    v=i;
                }
            }

        }
        return v;
    }
    static void findShortestPath(int distance[][], boolean inSet[], int minDist[], int points)
    {
        minDist[0]=0;
//        inSet[0]=true;
        for(int i=0;i<points;i++)
        {
            int v=findMinDistanceVertex(minDist, inSet);
            System.out.println("Vertex included: "+v+" weight for this: "+minDist[v]);
            inSet[v]=true;

            for(int j=0;j<points;j++)
            {
                if(!inSet[j] && minDist[j]>minDist[v]+distance[v][j])
                    minDist[j]=minDist[v]+distance[v][j];
            }
        }
    }
}
