import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int readFile(String str)
    {
        int count=0;
        str=str.trim();
        int start=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            {
                String subString=str.substring(start, i);
                start=i;
                subString=subString.trim();
                if(subString.length()>0)
                    count++;
            }
        }

        System.out.println(count+1);
        return count+1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner("dummy.txt");
        String mainContent="asda asdASD ASDS     DFD FG    DFG     ADSFDAS    SDF    ASDF asda      asd sd fsdf g sdfg dafg";
        mainContent=mainContent.trim();
        int size= mainContent.length();
        int k=3;
        int res[]= new int[k];
//        readFile(mainContent);

//        String splits[]= mainContent.split(" ");
//        System.out.println(splits.length);
        int start=0;
        int end=size/k;
        for(int i=0;i<k;i++)
        {
            end=(i+1)*size/k;
            String str=mainContent.substring(start, end);
            boolean flag=true;
            while(flag && end<mainContent.length())
            {
                if(mainContent.charAt(end)!=' ')
                    end++;
                else
                    flag=false;
            }
            start=end;
            Thread t1= new Thread(()->readFile(str));
            t1.start();
//            t1.run();

        }
//        return Arrays.stream(res).sum();
    }
}