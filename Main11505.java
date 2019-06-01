import java.io.*;
import java.util.StringTokenizer;

public class Main11505
{
    static int R = 1000000007;
    static long[] arr,tree;
    static int N,M,K;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N+1]; tree = new long[4*(N+1)];
        for(int i=1;i<=N;++i)
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
                long c = Long.parseLong(st.nextToken());
                update(1,1,N,b,c);
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
        if(start==end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = (init(node*2,start,mid)*init(node*2+1,mid+1,end))%R;
    }
    public static long query(int node, int start, int end, int lo, int hi)
    {
        if(hi<start || end<lo) return 1;
        if(lo<=start && end<=hi) return tree[node];
        int mid = (start+end)/2;
        return (query(node*2,start,mid,lo,hi)*query(node*2+1,mid+1,end,lo,hi))%R;
    }
    public static void update(int node, int start, int end, int idx, long val)
    {
        if(end<idx || idx<start) return;
        if(start==end)
        {
            tree[node] = val;
            arr[idx] = val;
            return;
        }
        int mid = (start+end)/2;
        update(node*2,start,mid,idx,val);
        update(node*2+1,mid+1,end,idx,val);
        tree[node] = (tree[node*2]*tree[node*2+1])%R;
    }
}
