import java.io.*;

public class Main1377
{
    static int[] tree;
    static int N,max;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        tree = new int[4*(1000000+2)];
        for(int i=1;i<=N;++i)
        {
            int cur = Integer.parseInt(br.readLine());
            max = Math.max(max,query(1,1,1000000+2,cur+1));
        }
        bw.write((max+1)+"");
        bw.close();
    }
    public static int query(int node, int start, int end, int val)
    {
        if(start>val) return tree[node];
        if(end<val) return 0;
        if(start==end)
        {
            ++tree[node]; return 0;
        }
        ++tree[node];
        int mid = (start+end)/2;
        return query(node*2,start,mid,val)+query(node*2+1,mid+1,end,val);
    }

}
