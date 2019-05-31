import java.io.*;
import java.util.StringTokenizer;

public class Main2243
{
    static int[] tree = new int[4*1000000];
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1)
            {
                int num = query(1,1,1000000,b);
                bw.write(num+"\n");
                update(1,1,1000000,num,-1);
            }
            else
            {
                update(1,1,1000000,b,Integer.parseInt(st.nextToken()));
            }
        }
        bw.close();
    }
    public static int query(int node, int start, int end, int rank)
    {
        if(start==end)
            return start;
        int mid = (start+end)/2;
        if(tree[node*2]>=rank) return query(node*2,start,mid,rank);
        else return query(node*2+1,mid+1,end,rank-tree[node*2]);
    }
    public static void update(int node, int start, int end, int target, int state)
    {
        if(start>target || end<target) return;
        if(start==end)
        {
            tree[node]+=state; return;
        }
        int mid = (start+end)/2;
        tree[node]+=state;
        update(node*2,start,mid,target,state);
        update(node*2+1,mid+1,end,target,state);
    }
}
