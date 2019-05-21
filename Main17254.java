import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17254
{
    static Key[] key;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        key = new Key[M];
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            key[i] = new Key(n,m,c);
        }
        Arrays.sort(key);
        for(Key k : key)
        {
            bw.write(k.c);
        }
        bw.close();
    }

}
class Key implements Comparable<Key>
{
    int n;
    int t;
    char c;
    Key(int n, int t,char c)
    {
        this.n = n; this.t = t; this.c = c;
    }
    public int compareTo(Key key)
    {
        return this.t==key.t?this.n-key.n:this.t-key.t;
    }
}
