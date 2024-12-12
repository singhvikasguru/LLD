import java.util.Scanner;

public class MrKim {
    static int minDistance=Integer.MAX_VALUE;
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

    public static int Mdistance(Pair p1, Pair p2)
    {
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
    public static void findMinDistance(Pair office, Pair home, Pair coordinate[])
    {
        int distance=0;
        distance+=Mdistance(office, coordinate[0]);
        for(int i=0;i<coordinate.length-1;i++)
            distance+=Mdistance(coordinate[i], coordinate[i+1]);
        distance+=Mdistance(coordinate[coordinate.length-1], home);
        minDistance=Math.min(minDistance, distance);
//        permutate(coordinate);
    }
    public static void permutate(Pair coordinates[], int pos, Pair office, Pair home)
    {
        if(pos==coordinates.length)
            findMinDistance(office, home, coordinates);
        for(int i=pos;i<coordinates.length;i++)
        {
            swap(coordinates, i, pos);
            permutate(coordinates, pos+1, office, home);
            swap(coordinates, pos, i);
        }
    }
    public static void swap(Pair coordinates[], int i, int j)
    {
        Pair dummy=coordinates[i];
        coordinates[i]=coordinates[j];
        coordinates[j]=dummy;
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int testCases= sc.nextInt();
        while(testCases>0)
        {
            testCases--;
            int points=sc.nextInt();
            Pair coordinates[]= new Pair[points];
            Pair home=new Pair(-1, -1);
            Pair office = new Pair(-1, -1);
            office.x=sc.nextInt();
            office.y= sc.nextInt();
            home.x=sc.nextInt();
            home.y=sc.nextInt();
            for(int i=0;i<points;i++)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                coordinates[i]= new Pair(x, y);
            }

            permutate(coordinates, 0, office, home);
            System.out.println("#"+(testCases+1)+" "+minDistance);
        }
    }
}
