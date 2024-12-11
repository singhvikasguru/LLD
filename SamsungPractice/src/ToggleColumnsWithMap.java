import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ToggleColumnsWithMap {
    public static void createMap(int mat[][], Map<String, Integer> map, int zeros[], int n, int m, int k)
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
                int val=map.getOrDefault(key.toString(), 0);
                map.put(key.toString(), val+1);
            }
//            zeros[i]=zer;
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
        Map<String, Integer> map= new HashMap<>();
        int zeros[]= new int[n];
        createMap(mat, map, zeros, n, m, k);

        int ans=0;
        for (String str:map.keySet())
        {

            if(map.get(str)>ans)
                ans=map.get(str);
        }
        System.out.println(ans);
    }
}
