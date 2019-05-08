import java.io.*;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197
{
    static int[] parent;
    static int[] rank;
    static PriorityQueue<Node1197> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        rank = new int[V+1];
        for(int i=0;i<=V;++i)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i=0;i<E;++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Node1197(u,v,d));
        }
        int n = 0;
        long sum = 0;
        while(!pq.isEmpty())
        {
            Node1197 node = pq.poll();
            if(find(node.u)==find(node.v))
                continue;
            merge(node.u,node.v);
            n++;
            sum += node.d;
            if(n==V-1) break;
        }
        bw.write(sum+"");
        bw.close();
    }
    public static int find(int u)
    {
        while(u!=parent[u])
            u=parent[u];
        return u;
    }
    public static void merge(int u,int v)
    {
        u = find(u); v = find(v);
        if(u==v) return;
        if(rank[u]>rank[v])
            parent[v] = u;
        else
            parent[u] = v;
        if(rank[u]==rank[v])
            rank[v]++;
    }

}
class Node1197 implements Comparable<Node1197>
{
    int u;
    int v;
    int d;
    Node1197(int u,int v,int d)
    {
        this.u=u;
        this.v=v;
        this.d=d;
    }
    public int compareTo(Node1197 node1197)
    {
        return this.d - node1197.d;
    }
}
