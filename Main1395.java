import java.io.*;
import java.util.StringTokenizer;

public class Main1395
{
    static int N,M;
    static int[] tree,lazy;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[4*(N+1)];
        lazy = new int[4*(N+1)];
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if(o==0)
            {
                update(1,1,N,s,t);
            }
            else
            {
                bw.write(query(1,1,N,s,t)+"\n");
            }
        }
        bw.close();
    }
    public static void prop(int node, int start, int end)
    {
        tree[node] = end-start+1-tree[node];
        if(start!=end)
        {
            lazy[node*2] ^= 1;
            lazy[node*2+1] ^= 1;
        }
        lazy[node] = 0;
    }
    public static void update(int node, int start, int end, int lo, int hi)
    {
        if(lazy[node]!=0) prop(node, start, end);
        if(end<lo || hi<start) return;
        if(lo<=start && end<=hi) {lazy[node]^=1; prop(node,start,end); return;}
        if(start==end) return;
        int mid = (start+end)/2;
        update(node*2,start,mid,lo,hi);
        update(node*2+1,mid+1,end,lo,hi);
        tree[node] = tree[node*2]+tree[node*2+1];
    }
    public static int query(int node, int start, int end, int lo, int hi)
    {
        if(lazy[node]!=0) prop(node,start,end);
        if(hi<start || end<lo) return 0;
        if(lo<=start && end<=hi) return tree[node];
        int mid = (start+end)/2;
        return query(node*2,start,mid,lo,hi)+query(node*2+1,mid+1,end,lo,hi);
    }
}
