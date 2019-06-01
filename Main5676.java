import java.io.*;
import java.util.StringTokenizer;

public class Main5676
{
    static int[] arr,tree;
    static int N,K;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s=br.readLine())!=null)
        {
            StringTokenizer st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N+1];
            tree = new int[4*(N+1)];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;++i)
                arr[i] = Integer.parseInt(st.nextToken());
            init(1,1,N);
            for(int i=0;i<K;++i)
            {
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("C"))
                {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if(Integer.signum(arr[a])!=Integer.signum(b))
                    {
                        update(1,1,N,a,Integer.signum(b));
                    }
                }
                else
                {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int q = query(1,1,N,a,b);
                    bw.write((q==0?q:q>0?"+":"-")+"");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
    public static int init(int node, int start, int end)
    {
        if(start==end) return tree[node]=Integer.signum(arr[start]);
        int mid = (start+end)/2;
        return tree[node]=init(2*node,start,mid)*init(2*node+1,mid+1,end);
    }
    public static void update(int node, int start, int end, int idx, int sig)
    {
        if(idx<start || end<idx) return;
        if(start==end) {tree[node]=sig; arr[idx]=sig; return;}
        int mid = (start+end)/2;
        update(node*2,start,mid,idx,sig);
        update(node*2+1,mid+1,end,idx,sig);
        tree[node] = tree[node*2]*tree[node*2+1];
    }
    public static int query(int node, int start, int end, int lo, int hi)
    {
        if(end<lo || hi<start) return 1;
        if(lo<=start && end<=hi) return tree[node];
        int mid = (start+end)/2;
        return query(2*node,start,mid,lo,hi)*query(2*node+1,mid+1,end,lo,hi);
    }
}
