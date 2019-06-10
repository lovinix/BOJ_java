import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916
{
    static int N,M;
    static PriorityQueue<Edge1916> pq = new PriorityQueue<>();
    static ArrayList<Edge1916>[] arr;
    static int[] dist;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=0;i<=N;++i)
            arr[i] = new ArrayList<>();
        for(int i=0;i<M;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Edge1916(v,w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(Edge1916 e : arr[start])
        {
            pq.offer(e);
            dist[e.v] = e.w;
        }
        while(!pq.isEmpty())
        {
            Edge1916 cur = pq.poll();
            for(Edge1916 next : arr[cur.v])
            {
                if(cur.w+next.w<dist[next.v])
                {
                    dist[next.v] = cur.w+next.w;
                    pq.offer(new Edge1916(next.v,cur.w+next.w));
                }
            }
        }
        bw.write(dist[end]+"");
        bw.close();
    }

}
class Edge1916 implements Comparable<Edge1916>
{
    int v,w;
    Edge1916(int v, int w)
    {
        this.v=v;this.w=w;
    }
    public int compareTo(Edge1916 edge1916)
    {
        return this.w - edge1916.w;
    }
}

