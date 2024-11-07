// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//input[] = {5,3,6,9,2}
public class Main {
    int count=0;
    public int findSubset(int input[], int i, int target, int sum)
    {
        if(sum==target)
        {
            sum=0;
            return 1;
        }
        if(i>=input.length)
            return 0;

        return findSubset(input, i+1, target, sum)+findSubset(input, i+1, target, sum+input[i]);
    }
    public static void main(String[] args) {
        int input[] = {5,3,6,9,2};
        Main obj= new Main();
//        boolean res=
        int res=obj.findSubset(input, 0, 8, 0);
        System.out.println(res);
    }
}