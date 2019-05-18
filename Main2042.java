import java.io.*;
import java.util.StringTokenizer;

public class Main2042
{
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
        arr = new long[N+1];
        tree = new long[4*(N+1)];
        for(int i=1;i<=N;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(arr,tree,1,1,N);
        for(int i=0;i<M+K;++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1)
            {
                update(tree, 1, 1, N, b, c - arr[b]);
                arr[b] = c;
            }
            else bw.write(query(tree,1,1,N,b,c)+"\n");
        }
        bw.close();
    }

    public static long init(long[] arr, long[] tree, int node, int start, int end)
    {
        if(start == end)
        {
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = init(arr,tree,node*2,start,mid) + init(arr,tree,node*2+1,mid+1,end);
    }

    public static void update(long[] tree, int node, int start, int end, int index, long diff)
    {
        if(!(start <= index && index <= end))
            return;
        tree[node] += diff;
        if(start != end)
        {
            int mid = (start + end) /2;
            update(tree, node*2, start, mid, index, diff);
            update(tree, node*2+1, mid+1, end, index, diff);
        }
    }

    public static long query(long[] tree, int node, int start, int end, int left, int right)
    {
        if(right<start || end<left)
            return 0;
        if(left<=start && end<=right)
            return tree[node];
        int mid = (start + end)/2;
        return query(tree, node*2, start, mid, left, right) + query(tree, node*2+1, mid+1, end, left, right);
    }
}
