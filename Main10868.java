import java.io.*;
import java.util.StringTokenizer;

public class Main10868
{
    static int N, M;
    static int[] arr,tree;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        tree = new int[4*(N+1)];
        for(int i=1;i<=N;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1,1,N);
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(query(1,1,N,a,b)+"\n");
        }
        bw.close();
    }

    public static int init(int node, int start, int end)
    {
        if(start == end)
        {
            return tree[node] = arr[start];
        }
        int mid = (start+end)/2;
        return tree[node] = Math.min(init(node*2,start,mid),init(node*2+1,mid+1,end));
    }

    public static int query(int node, int start, int end, int left, int right)
    {
        if(end<left || right<start)
            return Integer.MAX_VALUE;
        if(left<=start && end<=right)
            return tree[node];
        int mid = (start+end)/2;
        return Math.min(query(node*2,start,mid,left,right),query(node*2+1,mid+1,end,left,right));
    }
}
