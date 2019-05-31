import java.io.*;
import java.util.StringTokenizer;

public class Main2268
{
    static long[] tree;
    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[4*(N+1)];
        arr = new int[N+1];
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==0)
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bw.write(query(1,1,N, Math.min(a,b), Math.max(a,b))+"\n");
            }
            else
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                update(1,1,N,a,b);
            }
        }
        bw.close();
    }
    public static long query(int node, int start, int end, int low, int high)
    {
        if(start>high || end<low) return 0;
        if(low<=start && end<=high) return tree[node];
        int mid = (start+end)/2;
        return query(node*2,start,mid,low,high)+query(node*2+1,mid+1,end,low,high);
    }
    public static void update(int node, int start, int end, int idx, int val)
    {
        if(idx<start || idx>end) return;
        if(start==end)
        {
            arr[idx] = val;
            tree[node] = val;
            return;
        }
        tree[node] += val-arr[idx];
        int mid = (start+end)/2;
        update(node*2,start,mid,idx,val);
        update(node*2+1,mid+1,end,idx,val);
    }
}
