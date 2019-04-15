import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11401
{
    static final long prime = 1000000007;
    static long[] c;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        c = new long[N+1];
        Arrays.fill(c,-1);
        bw.write((((fac(N)*exp((int)fac(N-K),(int)prime-2)%prime)*exp((int)fac(K),(int)prime-2))%prime)+"");
        bw.close();
    }

    public static long fac(int n)
    {
        if(n==0) return 1;
        if(n==1) return 1;
        if(c[n]!=-1) return c[n];
        long ret = (n*fac(n-1))%prime;
        c[n] = ret;
        return ret;
    }

    public static long exp(int a,int n)
    {
        if(n==0) return 1;
        if(n==1) return a;
        long ret;
        if(n%2==0)
        {
            long t = exp(a,n/2);
            ret = (t*t)%prime;
            return ret;
        }
        else
        {
            long t = exp(a,n/2);
            ret = (((t*t)%prime)*a)%prime;
            return ret;
        }
    }
}
