import java.io.*;
import java.util.StringTokenizer;

public class Main17250
{
    static int[] parent;
    static long[] size;
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        size = new long[N+1];
        for(int i=1;i<=N;++i)
        {
            parent[i] = i;
        }
        for(int i=1;i<=N;++i)
        {
            size[i] = Long.parseLong(br.readLine());
        }
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            merge(u,v);
            bw.write(size[find(v)]+"\n");
        }

        bw.close();
    }
    public static int find(int u)
    {
        if(u==parent[u]) return u;
        return parent[u] = find(parent[u]);
    }
    public static void merge(int u,int v)
    {
        u = find(u); v = find(v);
        if(u==v) return;
        parent[u] = v;
        size[v]+=size[u];
    }
}
