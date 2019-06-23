import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main1640
{
    static int N,M;
    static BitSet r,c;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = new BitSet();
        c = new BitSet();
        for(int i=0;i<N;++i)
        {
            char[] ar = br.readLine().toCharArray();
            for(int j=0;j<M;++j)
            {
                char cur = ar[j];
                if(cur=='1')
                {
                    if(r.get(i)) r.clear(i);
                    else r.set(i);
                    if(c.get(j)) c.clear(j);
                    else c.set(j);
                }
            }
        }
        if(r.cardinality()%2==1)
        {
            if(c.cardinality()%2==1)
            {
                ans = Math.min(N-r.cardinality()+c.cardinality(), r.cardinality()+M-c.cardinality());
            }
        }
        else
        {
            if(c.cardinality()%2==0)
            {
                ans = Math.min(r.cardinality()+c.cardinality(), N-r.cardinality()+M-c.cardinality());
            }
        }
        bw.write(ans==Integer.MAX_VALUE?"-1":ans+"");
        bw.close();
    }

}

