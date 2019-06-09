import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17257
{
    static final long MOD=(long)1e9+9;
    static long N, Y, phi, ans;
    static long[] yarr;
    static ArrayList<Long> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        yarr = new long[(int)N+1];
        yarr[0] = 1;
        for(int i=1;i<=N;++i)
            yarr[i] = (yarr[i-1]*Y)%MOD;
        long yt = Y;
        for(long i=2; i<=yt; ++i)
        {
            if(yt%i==0)
            {
                prime.add(i);
                while(yt%i==0) yt/=i;
            }
        }
        phi= Y;
        for(long p : prime)
            phi=phi*(p-1)/p;
        long phitmp = 1;
        for(long n = N; n>0; --n)
            ans+= (n*((yarr[(int)N]-((phitmp=phitmp*(Y-phi)%MOD)*yarr[(int)n-1])+MOD)%MOD))%MOD;
        bw.write(ans+"");
        bw.close();
    }
}
