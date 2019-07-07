import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298
{
    static int n;
    static ArrayList<Pair> ar = new ArrayList<>();
    static int[] ans;
    static Stack<Pair> stk = new Stack<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;++i)
        {
            ar.add(new Pair(i,Integer.parseInt(st.nextToken())));
        }
        for(Pair v : ar)
        {
            while(!stk.isEmpty() && stk.peek().s<v.s)
                ans[stk.pop().i] = v.s;
            stk.push(v);
        }
        while(!stk.isEmpty())
            ans[stk.pop().i] = -1;
        for(int a : ans)
        {
            bw.write(a+" ");
        }
        bw.close();
    }

}
class Pair
{
    int i,s;
    Pair(int _i, int _s)
    {
        i=_i;s=_s;
    }
}
