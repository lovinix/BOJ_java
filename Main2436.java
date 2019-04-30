import java.io.*;
import java.util.StringTokenizer;

public class Main2436
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long G = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long ab = L/G;
        long i;
        for(i = (long)Math.sqrt(ab);i>0;--i)
        {
            if (ab % i == 0)
            {
                if(gcd(i*G,ab*G/i)==G)
                    break;
            }
        }
        bw.write(i*G+" "+(ab*G/i));
        bw.close();
    }
    public static long gcd(long a,long b)
    {
        long max = Math.max(a,b);
        long min = Math.min(a,b);
        return max%min==0?min:gcd(max%min,min);
    }
}
