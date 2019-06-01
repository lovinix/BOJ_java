import java.io.*;
import java.util.StringTokenizer;

public class Main1572
{
    static int N,K;
    static int[] arr,tree = new int[4*65537];
    static long sum;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=1;i<K;++i)
        {
            arr[i] = Integer.parseInt(br.readLine())+1;
            update(1,1,65537,arr[i],1);
        }
        for(int i=K;i<=N;++i)
        {
            arr[i] = Integer.parseInt(br.readLine())+1;
            update(1,1,65537,arr[i],1);
            sum+=query(1,1,65537,K/2+K%2)-1;
            update(1,1,65537,arr[i-K+1],-1);
        }
        bw.write(sum+"");
        bw.close();
    }
    public static void update(int node, int start, int end, int val, int flag)
    {
        if(end<val || start>val) return;
        tree[node]+=flag;
        if(start==end) return;
        int mid = (start+end)/2;
        update(node*2, start, mid, val,flag);
        update(node*2+1,mid+1,end,val,flag);
    }
    public static int query(int node, int start, int end, int rank)
    {
        if(start==end) return start;
        int mid = (start+end)/2;
        if(tree[node*2]>=rank)
        {
            return query(node*2,start,mid,rank);
        }
        else
        {
            return query(node*2+1,mid+1,end,rank-tree[node*2]);
        }
    }
}
