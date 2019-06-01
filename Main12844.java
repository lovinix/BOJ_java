import java.io.*;
import java.util.StringTokenizer;

public class Main12844
{
    static int[] arr,tree,lazy;
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1]; tree = new int[4*(N+1)]; lazy = new int[4*(N+1)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1,1,N);
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1"))
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1,1,N,a+1,b+1,c);
            }
            else
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bw.write(query(1,1,N,a+1,b+1)+"\n");
            }
        }
        bw.close();
    }
    public static int init(int node, int start, int end)
    {
        if(start==end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = init(node*2,start,mid)^init(node*2+1,mid+1,end);
    }
    public static void prop(int node, int start, int end)
    {
        tree[node]^=(end-start+1)%2==1?lazy[node]:0;
        if(start!=end)
        {
            lazy[node*2] ^= lazy[node];
            lazy[node*2+1] ^= lazy[node];
        }
        lazy[node] = 0;
    }
    public static void update(int node, int start, int end, int lo, int hi, int val)
    {
        if(lazy[node]!=0) prop(node,start,end);
        if(end<lo || hi<start) return;
        if(start==end) {lazy[node]^=val; prop(node,start,end); return;}
        lazy[node] ^= val;
        int mid = (start+end)/2;
        update(node*2,start,mid,lo,hi,val);
        update(node*2+1,mid+1,end,lo,hi,val);
        tree[node] = tree[node*2]^tree[node^2+1];
    }
    public static int query(int node, int start, int end, int lo, int hi)
    {
        if(lazy[node]!=0) prop(node,start,end);
        if(end<lo || hi<start) return 0;
        if(lo<=start && end<=hi) return tree[node];
        int mid = (start+end)/2;
        return query(node*2,start,mid,lo,hi)^query(node*2+1,mid+1,end,lo,hi);
    }
}
