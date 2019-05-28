import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static int N,K;
    static int[] f,b,o;
    static Vec[] tot;
    static int[] tree1, tree2;
    static long ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        f = new int[N]; b = new int[N];
        o = new int[K]; tot = new Vec[2*N+K];
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            f[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            tot[i] = new Vec(f[i],i);
            tot[N+i] = new Vec(b[i],N+i);
        }
        for(int i=0;i<K;++i)
        {
            o[i] = Integer.parseInt(br.readLine());
            tot[2*N+i] = new Vec(o[i], 2*N+i);
        }
        Arrays.sort(tot,(o1,o2)->o1.val-o2.val);
        // coordinate compression
        int n = 0;
        for(;n<tot.length;)
        {
            int m = 1;
            for(;n+m<tot.length;++m)
            {
                if(tot[n].val==tot[n+m].val)
                    tot[n+m].val=n+1;
                else
                    break;
            }
            tot[n].val = n+1;
            n+=m;
        }
        Arrays.sort(tot,(o1,o2)->o1.idx-o2.idx);
        tree1 = new int[4*(n+1)];
        Arrays.fill(tree1,-1);
        for(int i=2*N;i<tot.length;++i)
            update1(1,1,n,tot[i].val,i-2*N);
        for(int i=0;i<N;++i)
        {
            tot[i].lastidx = query1(1,1,n, Math.min(tot[i].val,tot[i+N].val), Math.max(tot[i].val,tot[i+N].val));
            tot[i].val = Math.max(tot[i].val,tot[i+N].val);
        }
        Arrays.sort(tot,0,N,(o1,o2)->o1.lastidx-o2.lastidx);
        tree2 = new int[4*n];
        for(int i=N-1,j=2*N+K-1;i>=0;--i)
        {
            while(j-2*N>tot[i].lastidx)
                update2(1,1,n,tot[j--].val);
            int cnt = query2(1,1,n,tot[i].val);
            if(tot[i].lastidx==-1)
                ans+=cnt%2==0?f[tot[i].idx]:b[tot[i].idx];
            else
                ans+=cnt%2==0? Math.max(f[tot[i].idx],b[tot[i].idx]): Math.min(f[tot[i].idx],b[tot[i].idx]);
        }
        bw.write(ans+"");
        bw.close();
    }
    public static void update1(int node, int start, int end, int val, int idx)
    {
        if(val<start || end<val) return;
        if(start<=val && val<=end)
            tree1[node]= Math.max(tree1[node],idx);
        if(start==end) return;
        int mid = (start+end)/2;
        update1(node*2, start, mid, val, idx);
        update1(node*2+1, mid+1, end, val, idx);
    }
    public static int query1(int node, int start, int end, int low, int high)
    {
        if(end<low || high<=start) return -1;
        if(low<=start && end<high) return tree1[node];
        int mid = (start+end)/2;
        return Math.max(query1(node*2,start,mid,low,high),query1(node*2+1,mid+1,end,low,high));
    }
    public static void update2(int node, int start, int end, int val)
    {
        if(val<start || end<val) return;
        if(start<= val && val<= end)
            tree2[node]++;
        if(start==end) return;
        int mid = (start+end)/2;
        update2(node*2,start,mid,val);
        update2(node*2+1,mid+1,end,val);
    }
    public static int query2(int node, int start, int end, int val)
    {
        if(end<val) return 0;
        if(start>=val) return tree2[node];
        int mid = (start+end)/2;
        return query2(node*2,start,mid,val)+query2(node*2+1,mid+1,end,val);
    }
}
class Vec
{
    int val;
    int idx;
    int lastidx;
    Vec(int val,int idx)
    {
        this.val = val;
        this.idx = idx;
    }
}