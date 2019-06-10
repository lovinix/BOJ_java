import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main434_8
{
    static String[] arr = new String[6];
    static ArrayList<Poker> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(),",");
        for(int i=0;i<6;++i)
            arr[i] = st.nextToken();
        for(int i=0;i<5;++i)
        {
            for(int j=i+1;j<6;++j)
            {
                ans.add(new Poker(arr[i],arr[j]));
            }
        }
        Collections.sort(ans);
        for(Poker p : ans)
            bw.write(p+"\n");
        bw.close();
    }

}
class Poker implements Comparable<Poker>
{
    int n1, n2;
    char c1, c2;
    String s1, s2;
    int flag;
    Poker(String s1, String s2)
    {
        this.s1 = s1; this.s2 = s2;
        this.n1 = s1.charAt(0)<='9'?s1.charAt(0)-'0':s1.charAt(0)-'a'+10;
        this.n2 = s2.charAt(0)<='9'?s2.charAt(0)-'0':s2.charAt(0)-'a'+10;
        this.c1 = s1.charAt(1);
        this.c2 = s2.charAt(1);
        if(Math.abs(n2-n1)==1 || Math.abs(n2-n1)==14)
            flag = 1;
        else if(n1==n2)
            flag = 2;
        else
            flag = 3;
    }
    public int compareTo(Poker poker)
    {
        if(this.flag!=poker.flag)
        {
            return this.flag-poker.flag;
        }
        if((c1==c2 && poker.c1==poker.c2) || (c1!=c2 && poker.c1!=poker.c2))
        {
            if(Math.max(n1,n2) == Math.max(poker.n1,poker.n2))
            {
                if(Math.min(n1,n2) == Math.min(poker.n1,poker.n2))
                {
                    if((n1>n2 && c1=='b')||(n1<n2 && c2=='b')) return -1;
                    return 1;
                }
                else
                {
                    return Math.min(poker.n1,poker.n2)-Math.min(n1,n2);
                }
            }
            else
            {
                return Math.max(poker.n1,poker.n2) - Math.max(n1,n2);
            }
        }
        else
        {
            return c1==c2?-1:1;
        }
    }
    public String toString()
    {
        return s1+s2;
    }
}