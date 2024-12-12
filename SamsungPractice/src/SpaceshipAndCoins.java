import java.util.Scanner;

public class SpaceshipAndCoins {
    static int maxCoin=0;
    public static void playGame(int mat[][], int rowLimit, int row, int col, boolean bombUsed, int rowSafe, int coins)
    {
        if(row>=rowLimit || row<0 || col>=5 || col<0)
        {
            maxCoin=Math.max(coins, maxCoin);
            return ;
        }
        if(mat[row][col]==1)
        {
            playGame(mat, rowLimit, row-1, col, bombUsed, rowSafe, coins+1);
            playGame(mat, rowLimit, row-1, col-1, bombUsed, rowSafe, coins+1);
            playGame(mat, rowLimit, row-1, col+1, bombUsed, rowSafe, coins+1);
        }
        else if(mat[row][col]==0)
        {
            playGame(mat, rowLimit, row-1, col, bombUsed, rowSafe, coins);
            playGame(mat, rowLimit, row-1, col-1, bombUsed, rowSafe, coins);
            playGame(mat, rowLimit, row-1, col+1, bombUsed, rowSafe, coins);
        }
        else
        {
            if(!bombUsed)
            {
                bombUsed=true;
                rowSafe=4;
                playGame(mat, rowLimit, row-1, col, bombUsed, rowSafe, coins);
                playGame(mat, rowLimit, row-1, col-1, bombUsed, rowSafe, coins);
                playGame(mat, rowLimit, row-1, col+1, bombUsed, rowSafe, coins);
            } else if (bombUsed && rowSafe>0) {
                rowSafe--;
                playGame(mat, rowLimit, row-1, col, bombUsed, rowSafe, coins);
                playGame(mat, rowLimit, row-1, col-1, bombUsed, rowSafe, coins);
                playGame(mat, rowLimit, row-1, col+1, bombUsed, rowSafe, coins);

            }
            else
            {
                maxCoin=Math.max(maxCoin, coins);
                return;
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int row=sc.nextInt();
        int mat[][]= new int[row][5];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<5;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        int r=6;
        int col=2;
        boolean bombUsed=false;
        int isRowSafe=0;
        playGame(mat, row, row-1, col, bombUsed, isRowSafe, 0);
        playGame(mat, row, row-1, col-1, bombUsed, isRowSafe, 0);
        playGame(mat, row, row-1, col+1, bombUsed, isRowSafe, 0);
        System.out.println(maxCoin);
    }
}
