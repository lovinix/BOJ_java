import java.io.*;

public class Main17268
{
    static long[] dp = new long[10001];
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[2] = 1;
        for(int i=4;i<=N;i+=2)
        {
            for(int j=0;j<=i-2;j+=2)
            {
                dp[i]+=dp[j]*dp[i-j-2];
                dp[i]%=987654321;
            }
        }
        bw.write(dp[N]+"");
        bw.close();
    }

}
