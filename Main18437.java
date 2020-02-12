import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M,num;
    static int[] ln = new int[100010];
    static int[] rn = new int[100010];
    static ArrayList<Integer>[] adj = new ArrayList[100010];
    static BitSet bset = new BitSet();

    public static void main(String[] args) throws Exception
    {
        N = Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<=N;++i)
            adj[i] = new ArrayList<>();
        for(int i=1;i<=N;++i)
        {
            int p = Integer.parseInt(st.nextToken());
            adj[p].add(i);
        }
        dfs(1,0);
        M = Integer.parseInt(br.readLine());
        bset.set(1,N+1,true);
        while(M-->0)
        {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if(f==1 || f==2)
            {
                if(ln[i]==rn[i]) continue;
                bset.set(ln[i]+1, rn[i]+1, f-1==0);
            }
            else
            {
                if(ln[i]==rn[i]) bw.write("0\n");
                else bw.write(bset.get(ln[i]+1,rn[i]+1).cardinality()+"\n");
            }
        }
        bw.close();
    }

    public static void dfs(int u, int p)
    {
        ln[u] = ++num;
        for(int v : adj[u])
        {
            if(v==p) continue;
            dfs(v, u);
        }
        rn[u] = num;
    }
}
