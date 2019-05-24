import java.io.*;
import java.util.StringTokenizer;

public class Main6549
{
    static int[] arr,tree;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            arr = new int[N+1];
            tree = new int[4*(N+1)];
            for(int i=1;i<=N;++i)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            init(1,1,N);
            long max = area(1,N);
            bw.write(max+"\n");
        }
        bw.close();
    }

    public static int init(int node, int start, int end)
    {
        if(start==end)
            return tree[node] = start;
        int mid = (start+end)/2;
        int l = init(node*2,start,mid);
        int r = init(node*2+1,mid+1,end);
        if(arr[l]>arr[r]) return tree[node] = r;
        else return tree[node] = l;
    }

    public static int query(int node, int start, int end, int left, int right)
    {
        if(right<start || end < left) return -1;
        if(left<=start && end<=right) return tree[node];
        int mid = (start+end)/2;
        int l = query(node*2,start,mid,left,right);
        int r = query(node*2+1,mid+1,end,left,right);
        if(l==-1) return r;
        if(r==-1) return l;
        if(arr[l]>arr[r]) return r;
        else return l;
    }

    public static long area(int left, int right)
    {
        int idx = query(1,1,N,left ,right);
        long a = arr[idx]*(long)(right-left+1);
        if(left<idx)
            a = Math.max(a, area(left, idx-1));
        if(idx<right)
            a = Math.max(a, area(idx+1,right));
        return a;
    }
}
