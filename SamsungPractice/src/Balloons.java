import java.util.Scanner;

public class Balloons {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]= new int[n+2];
        for(int i=1;i<=n;i++)
        {
            nums[i]= sc.nextInt();
        }
        nums[0]=1;
        nums[n+1]=1;
        int memo[][]= new int[n+2][n+2];
        System.out.println(burst(memo, nums, 0, n+1));
    }
    public static int burst(int memo[][], int nums[], int left, int right)
    {
        if(left>right-1)
            return 0;
        if(memo[left][right]!=0)
            return memo[left][right];
        int ans=0;
        for(int i=left+1;i<right;i++)
        {
            ans=Math.max(ans, nums[left]*nums[i]*nums[right]+burst(memo, nums, left, i)+burst(memo, nums, i, right));
        }
        memo[left][right]=ans;
        return ans;
    }
}
