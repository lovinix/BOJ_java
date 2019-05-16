import java.io.*;
import java.util.StringTokenizer;

public class Main17204
{
    static int[] arr;
    static int N, K;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
            rank[i] = 1;
        }
        int ans = 0;
        for(int i=0;;)
        {
            int next = arr[i];
            if(next == K)
            {
                System.out.print((ans+1));
                return;
            }
            merge(i,next);
            i = next;
            ans++;
        }
    }
    public static int find(int u)
    {
        if(u==parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }
    public static void merge(int u, int v)
    {
        u = find(u); v = find(v);
        if(u==v)
        {
            System.out.print("-1");
            System.exit(0);
        }
        if(rank[u]<rank[v])
            parent[u] = v;
        else
        {
            parent[v] = u;
        }
        if(rank[u]==rank[v])
            rank[u]++;
    }
}
