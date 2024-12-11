/**
 *You are given an unsorted array with both positive and negative elements. You have to find the smallest positive number missing from the array in O(n) time using constant extra space.
 *
 * Input: First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.
 *
 * Output: Single line output, print the smallest positive number missing.
 *
 * Constraints:
 *
 * 1<=T<=100 and 1<=N<=100
 *
 * Example:
 *
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 5
 * 0 -10 1 3 -20
 * Output:
 * 6
 * 2
 *
 */


import java.util.Scanner;

public class MissingSmallestPositive {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int testCases= sc.nextInt();
        for(int t=0;t<testCases;t++)
        {
            int size= sc.nextInt();
            int pos=0;
            int arr[]= new int[size];
            for(int i=0;i<size;i++)
            {
                arr[i]=sc.nextInt();
                if(arr[i]>0)
                    pos++;
            }
            if(pos==0)
                System.out.println(1);
            if(pos==size)
                System.out.println(size+1);

            boolean visited[]= new boolean[size];
            for(int i=0;i<size;i++)
            {
                if(arr[i]>0)
                    visited[arr[i]-1]=true;
            }
            for(int i=0;i<size;i++)
            {
                if(visited[i]==false)
                {
                    System.out.println(i+1);
                    break;
                }

            }

        }
    }
}
