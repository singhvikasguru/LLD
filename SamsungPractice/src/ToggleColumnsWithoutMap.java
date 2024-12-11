import java.util.Arrays;
import java.util.Scanner;

public class ToggleColumnsWithoutMap {
    public static void createMap(int mat[][], String map[], int zeros[], int n, int m, int k)
    {

        for(int i=0;i<n;i++)
        {
            StringBuilder key= new StringBuilder();
            int zer=0;
            for(int j=0;j<m;j++)
            {
                key.append(j);
                if (mat[i][j]==0)
                    zer++;
            }
            if(zer<=k && (k-zer)%2==0)
            {
                map[i]=key.toString();
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int k= sc.nextInt();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int mat[][]= new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]= sc.nextInt();
            }
        }
        String map[]= new String[n];
        int zeros[]= new int[n];
        createMap(mat, map, zeros, n, m, k);

        int ans=0;
        int count=0;
        Arrays.sort(map);
        for(int i=0;i<map.length-1;i++)
        {
            if(!map[i].equals(""))
            {
                if(map[i].equals(map[i+1]))
                    count++;
                else
                    count=1;
                if(count>ans)
                    ans=count;
            }
        }

        System.out.println(ans);
    }
}
