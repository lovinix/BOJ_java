import java.io.*;
import java.util.StringTokenizer;

public class Main1275
{
    static long[] arr,tree;
    static int N,Q;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[N+1];
        tree = new long[4*(N+1)];
        for(int i=1;i<=N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1,1,N);
        for(int i=0;i<Q;++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            bw.write(query(1,1,N, Math.min(x,y), Math.max(x,y))+"\n");
            update(1,1,N,a,b-arr[a]);
            arr[a] = b;
        }
        bw.close();
    }
    public static long init(int node, int start, int end)
    {
        if(start==end)
        {
            return tree[node]=arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(node*2,start,mid) + init(node*2+1,mid+1,end);
    }
    public static void update(int node, int start, int end, int target, long diff)
    {
        if(!(start<=target && target<=end))
            return;
        tree[node] += diff;
        if(start!=end)
        {
            int mid = (start+end)/2;
            update(node*2,start,mid,target,diff);
            update(node*2+1,mid+1,end,target,diff);
        }
    }
    public static long query(int node, int start, int end, int left, int right)
    {
        if(right<start || end<left)
            return 0;
        if(left<=start && end<=right)
            return tree[node];
        int mid = (start+end)/2;
        return query(node*2, start, mid, left, right) + query(node*2+1,mid+1,end,left,right);
    }
}
