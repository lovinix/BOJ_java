import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main18436
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static BitSet bset = new BitSet();
    public static void main(String[] args) throws Exception
    {
        N = Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i)
        {
            int v = Integer.parseInt(st.nextToken());
            if(v%2==1) bset.set(i);
        }
        M = Integer.parseInt(br.readLine());
        while(M-->0)
        {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(f==1)
            {
                if(r%2==1) bset.set(l);
                else bset.clear(l);
            }
            else
            {
                bw.write((f==3?bset.get(l,r+1).cardinality():(r-l+1)-bset.get(l,r+1).cardinality())+"\n");
            }
        }
        bw.close();
    }
}
