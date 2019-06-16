import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707
{
    static ArrayList<Integer>[] arr;
    static int[] set;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        tc : for(int tc=0;tc<K;++tc)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V+1];
            set = new int[V+1];
            for(int i=0;i<=V;++i)
                arr[i] = new ArrayList<>();
            for(int i=0;i<E;++i)
            {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v);
                arr[v].add(u);
            }
            for(int start=1; start<=V;++start)
            {
                q = new ArrayDeque<>();
                if(set[start]!=0)
                    continue;
                set[start] = 1;
                q.offer(start);
                while(!q.isEmpty())
                {
                    int cur = q.poll();
                    for(int next : arr[cur])
                    {
                        if(set[next]!=0)
                        {
                            if(set[next]==set[cur])
                            {
                                bw.write("NO\n");
                                continue tc;
                            }
                            else
                                continue;
                        }
                        set[next] = set[cur]==1?2:1;
                        q.offer(next);
                    }
                }
            }
            bw.write("YES\n");
        }
        bw.close();
    }

}
