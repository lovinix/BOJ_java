import java.io.*;
import java.util.StringTokenizer;

public class Main12899
{
    static int[] tree = new int[4*(2000000+1)];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(t==1) update(1,1,2000000,x);
            else bw.write(query(1,1,2000000,x)+"\n");
        }
        bw.close();
    }
    public static void update(int node, int s, int e, int v)
    {
        if(v<s || e<v) return;
        if(s<=v && v<=e) tree[node]++;
        if(s==e) return;
        int m = (s+e)/2;
        update(node*2,s,m,v);
        update(node*2+1,m+1,e,v);
    }
    public static int query(int node, int s, int e, int t)
    {
        if(s==e)
        {
            tree[node]--;
            return s;
        }
        if(tree[node*2]>=t)
        {
            tree[node]--;
            return query(node*2,s,(s+e)/2,t);
        }
        else
        {
            tree[node]--;
            return query(node*2+1,(s+e)/2+1,e,t-tree[node*2]);
        }

    }
}
