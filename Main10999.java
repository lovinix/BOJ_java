import java.io.*;
import java.util.StringTokenizer;

public class Main10999
{
    static long[] arr, tree, lazy;
    static int N, M, K;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        tree = new long[4 * (N + 1)];
        lazy = new long[4 * (N + 1)];
        for (int i = 1; i <= N; ++i)
        {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1,1,N);
        for(int i=0;i<M+K;++i)
        {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1"))
            {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update(1,1,N,b,c,d);
            }
            else
            {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                bw.write(query(1,1,N,b,c)+"\n");
            }
        }
        bw.close();
    }

    public static long init(int node, int start, int end)
    {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    public static long query(int node, int start, int end, int lo, int hi)
    {
        if (lazy[node] != 0)
            prop(node,start,end);
        if (end < lo || hi < start) return 0;
        if (start == end)
            return tree[node];
        int mid = (start + end) / 2;
        if(lo<=start && end<=hi) return tree[node];
        return query(node*2,start,mid,lo,hi)+query(node*2+1,mid+1,end,lo,hi);
    }

    public static void update(int node, int start, int end, int lo, int hi, long val)
    {
        if(lazy[node]!=0)
            prop(node, start, end);
        if(end<lo || hi<start) return;
        if(lo <= start && end <= hi) {lazy[node]+=val; prop(node,start,end); return;}
        int mid = (start+end)/2;
        update(node*2,start,mid,lo,hi,val);
        update(node*2+1,mid+1,end,lo,hi,val);
        tree[node] = tree[node*2]+tree[node*2+1];
    }

    public static void prop(int node, int start, int end)
    {
        tree[node] += lazy[node] * (end-start+1);
        if(start!=end)
        {
            lazy[node*2]+=lazy[node];
            lazy[node*2+1]+=lazy[node];
        }
        lazy[node] = 0;
    }
}
