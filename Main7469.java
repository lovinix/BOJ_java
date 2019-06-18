import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main7469
{
    static int N, M;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[4 * N + 1];
        for (int i = 0; i <= 4 * N; ++i)
        {
            tree[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i)
            update(1,1,N,i,Integer.parseInt(st.nextToken()));
        for(int i=1;i<=2*N+1;++i)
            Collections.sort(tree[i]);
        for(int i=1;i<=M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = (int)-1e9; int r = (int)1e9;
            while(l<=r)
            {
                int mid = (l+r)/2;
                if(query(1,1,N,a,b,mid)<v) l = mid+1;
                else r = mid-1;
            }
            bw.write((l-1)+"\n");
        }
        bw.close();
    }

    public static void update(int node, int start, int end, int idx, int val)
    {
        if(start>idx || end<idx) return;
        tree[node].add(val);
        if(start==end) return;
        int mid = (start+end)/2;
        update(node*2,start,mid,idx,val);
        update(node*2+1,mid+1,end,idx,val);
    }

    public static int query(int node, int start, int end, int left, int right, int val)
    {
        if(start>right || end<left) return 0;
        if(left<=start && end<=right) return upper_bound(node, val);
        int mid = (start+end)/2;
        return query(node*2,start,mid,left,right,val) + query(node*2+1,mid+1,end,left,right,val);
    }

    public static int upper_bound(int node, int val)
    {
        int l = 0, r = tree[node].size()-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(tree[node].get(mid)<val)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }

}
