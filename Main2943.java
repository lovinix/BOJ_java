import java.io.*;
import java.util.StringTokenizer;

public class Main2943
{
    static int N,M;
    static int K;
    static int[] tree, arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = (int) Math.sqrt(N);
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
        }
        bw.close();
    }
    public static void update(int node, int s, int e, int l, int r)
    {
        if(s>r || e<l) return;
        if(l<=s && e<=r) tree[node]++;
        if(s==e)
        {
            arr[s]++;
            tree[node]++;
        }
        int m = (s+e)/2;
        update(node*2,s,m,l,r);
        update(node*2+1,m+1,e,l,r);
    }
}
