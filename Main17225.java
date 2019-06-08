import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17225
{
    static int A,B,N;
    static Ord[] ord = new Ord[2];
    static int tcur, tot;
    static Queue<Ord>[] q = new LinkedList[2];
    static ArrayList<Integer>[] ans = new ArrayList[2];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        q[0] = new LinkedList<>(); q[1] = new LinkedList<>();
        ans[0] = new ArrayList<>(); ans[1] = new ArrayList<>();
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int c = st.nextToken().charAt(0)=='B'?0:1;
            int m = Integer.parseInt(st.nextToken());
            q[c].offer(new Ord(t,m));
            tot+=m;
        }
        ord[0] = new Ord(0,0); ord[1] = new Ord(0,0);
        int idx = 1, min = 0;
        while(true)
        {
            for(int i=0;i<2;++i)
            {
                ord[i].r -= min;
                if(ord[i].r<=0 && ord[i].m>0)
                {
                    ord[i].m--;
                    ord[i].r = i==0?A:B;
                    if(ord[i].m>0) ans[i].add(idx++);
                }
                if (!q[i].isEmpty() && ord[i].m <= 0)
                {
                    if (tcur >= q[i].peek().t)
                    {
                        ord[i] = q[i].poll();
                        ord[i].r += i==0?A:B;
                        ans[i].add(idx++);
                    }
                    else ord[i].r = q[i].peek().t - tcur;
                }
                if(q[i].isEmpty() && ord[i].m<=0)
                    ord[i].r = Integer.MAX_VALUE;
            }
            min = Math.min(ord[0].r,ord[1].r);
            tcur+=min;
            if(idx>tot) break;
        }
        bw.write(ans[0].size()+"\n");
        for(int a : ans[0])
            bw.write(a+" ");
        bw.write("\n"+ans[1].size()+"\n");
        for(int a : ans[1])
            bw.write(a+ " ");
        bw.close();
    }

}
class Ord
{
    int t,m;
    int r = 0;
    Ord(int t, int m)
    {
        this.t = t; this.m = m;
    }
}
