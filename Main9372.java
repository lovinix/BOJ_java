import java.io.*;
import java.util.StringTokenizer;

public class Main9372
{
    static int[] parent,size;
    static int ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;++tc)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            size = new int[N+1];
            ans = 0;
            for(int i=0;i<=N;++i)
            {
                parent[i] = i;
                size[i] = 1;
            }
            for(int i=0;i<M;++i)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                merge(a,b);
            }
            bw.write(ans+"\n");
        }
        bw.close();
    }
    public static int find(int u)
    {
        if(u==parent[u]) return u;
        return parent[u] = find(parent[u]);
    }
    public static void merge(int u, int v)
    {
        u = find(u); v = find(v);
        if(u==v) return;
        parent[v] = u;
        size[u] +=size[v];
        ans++;
    }

}
