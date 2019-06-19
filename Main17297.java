import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main437_5
{
    static ArrayList<Integer> arr = new ArrayList<>();
    static String[] str = {"Messi","Messi Gimossi"};
    static char ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr.add(str[0].length());arr.add(str[1].length());
        for(int n=2;;++n)
        {
            long next = (long)arr.get(n-1)+(long)arr.get(n-2)+1;
            if(next>((2<<30)-1)) break;
            arr.add((int)next);
        }
        int M = Integer.parseInt(br.readLine());
        int idx = Collections.binarySearch(arr,M);
        if(idx>=0)
        {
            System.out.print("i");
            return;
        }
        else
            recv(-1*idx-1,M);
        bw.write(ans==' '?"Messi Messi Gimossi":String.valueOf(ans));
        bw.close();
    }
    public static void recv(int idx, int m)
    {
        if(idx==0 || idx==1)
        {
            ans = str[idx].charAt(m-1);
            return;
        }
        if(m<=arr.get(idx-1))
        {
            recv(idx-1,m);
            return;
        }
        if(m==arr.get(idx-1)+1)
        {
            ans = ' ';
            return;
        }
        recv(idx-2,m-arr.get(idx-1)-1);
    }
}
