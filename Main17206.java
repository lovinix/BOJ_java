import java.io.*;
import java.util.StringTokenizer;

public class Main17206
{
    static long[] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp = new long[80001];
        for(int i=1;i<=80000;++i)
        {
            dp[i] = dp[i-1] + (i%3==0?i:0) + (i%7==0?i:0) + (i%21==0?-i:0);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements())
        {
            bw.write(dp[Integer.parseInt(st.nextToken())]+"\n");
        }
        bw.close();
    }

}
