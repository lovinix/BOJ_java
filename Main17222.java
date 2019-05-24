import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17222
{
    static int N,M;
    static long[][] capacity,flow;
    static long[] in;
    static boolean[][] adj;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        capacity = new long[N+M+2][N+M+2];
        flow = new long[N+M+2][N+M+2];
        adj = new boolean[N+M+2][N+M+2];
        in = new long[N+M+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i)
        {
            in[i] = Long.parseLong(st.nextToken());
            capacity[i][0] = Long.MAX_VALUE;
            adj[i][0] = adj[0][i] = true;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=N+1;i<=N+M;++i)
        {
            in[i] = Long.parseLong(st.nextToken());
            capacity[N+M+1][i] = in[i];
            adj[N+M+1][i] = adj[i][N+M+1] = true;
        }
        for(int i=N+1;i<=N+M;++i)
        {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while(st.hasMoreElements())
            {
                int next = Integer.parseInt(st.nextToken());
                adj[i][next] = adj[next][i] = true;
                capacity[i][next] = in[next];
            }
        }
        long ans = 0;
        while(true)
        {
            int[] prev = new int[N+M+2];
            q.clear();
            q.add(N+M+1);
            prev[N+M+1]=N+M+1;
            while(!q.isEmpty())
            {
                int cur = q.poll();
                for(int next = N+M+1; next >= 0; --next)
                {
                    if(!adj[cur][next]) continue;
                    if(prev[next] !=0 ) continue;
                    if(capacity[cur][next] - flow[cur][next] >0)
                    {
                        q.add(next);
                        prev[next] = cur;
                    }
                }
            }
            if(prev[0] == 0) break;
            long min = Long.MAX_VALUE;
            for(int cur = 0; prev[cur] != cur; cur = prev[cur])
            {
                min = Math.min(min,capacity[prev[cur]][cur] - flow[prev[cur]][cur]);
            }
            for(int cur = 0; prev[cur] != cur; cur = prev[cur])
            {
                flow[prev[cur]][cur] += min;
                flow[cur][prev[cur]] -= min;
            }
            ans+=min;
        }
        bw.write(ans+"");
        bw.close();
    }

}
