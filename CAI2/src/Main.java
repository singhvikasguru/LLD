import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
// mat= nXm, every element is integer, 1-1L, increase by one or leave as it is, x-> x+1/x+0, for every elements
// find any mat where no consecutive elements are same-> top, right, left, bottom
/*
Tree-> leaf.val > root
n*m*2^n
1,1,3, 4
T, T, F, F
1, 1, 1, 1
0, 1, 0, 1


odd, odd, odd, even
1, 1, 1, 0

1, 0, 1, 1
1, 1, 0, 1
odd, even, odd, even
even, odd, even, odd

0, -2, -1, -n

2, 1, 3, 4
operation=[true, false, true, false]
2,1,1,3


1,1,2,3
2,1,2,3
*/
public class Main {
    public static void main(String[] args) {
//        int n=4;
//        int mat[]= new int[n];
//        int res[]= new int[n];
//        int ans[]= new int[n];
//        mat[0]=1;
//        mat[1]=1;
//        mat[2]=3;
//        mat[3]=4;
//
//        boolean changed[]= new boolean[n];
//        for(int i=0;i<n;i++)
//        {
//            res[i]=mat[i]%2;
//            ans[i]=i%2;
//            if(res[i]!=ans[i])
//                mat[i]++;
//        }
//        System.out.println(mat[i]);
        List<Integer> lst= new ArrayList<>();
        int n=3;
        int m=4;
        int mat[][]= new int[n][m];
        int res[][]= new int[n][m];
        int des[][]= new int[n][m];
        mat[0][0]=1;
        mat[0][1]=1;
        mat[0][2]=1;
        mat[0][3]=1;
        mat[1][0]=1;
        mat[1][1]=1;
        mat[1][2]=1;
        mat[1][3]=1;
        mat[2][0]=1;
        mat[2][1]=1;
        mat[2][2]=1;
        mat[2][3]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                res[i][j]= mat[i][j]%2;
                des[i][j]=(i+j)%2;
                if(res[i][j]!=des[i][j])
                    mat[i][j]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

//        helper(mat, 0, 0);
    }
}