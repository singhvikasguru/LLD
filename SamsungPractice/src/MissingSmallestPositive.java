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
    public static int movePositives(int arr[])
    {
        int posIndex=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                int temp=arr[i];
                arr[i]=arr[posIndex];
                arr[posIndex]=temp;
                posIndex++;
            }

        }
        return posIndex;
    }
    public static int findMin(int arr[], int posIndex)
    {
        for(int i=0;i<posIndex;i++)
        {
            int val=Math.abs(arr[i]);
            if(val-1<posIndex && arr[val-1]>0)
                arr[val-1]*=-1;
        }

        for(int i=0;i<posIndex;i++)
            if(arr[i]>0)
            {
                return i+1;
            }
        return posIndex+1;
    }

    public static int findMinOn(int arr[])
    {
        int size=arr.length;
        boolean visited[]= new boolean[size];
        for(int i=0;i<size;i++)
        {
            if(arr[i]>0)
                visited[arr[i]-1]=true;
        }
//        for(int i=0;i<size;i++)
//            System.out.print(visited[i]+" ");
        for(int i=0;i<size;i++)
        {
            if(visited[i]==false)
            {
                return i+1;
            }

        }
        return size+1;
    }

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

            int posIndex=movePositives(arr);
            System.out.println(findMinOn(arr));
            System.out.println(findMin(arr, posIndex));

        }
    }
}
