import java.io.*;
import java.util.Arrays;

public class Main424_3
{
    static int[] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[100000];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int[] coin = {1,2,5,7};
        dp[1] = 1; dp[2] = 1; dp[5] = 1; dp[7] = 1;
        dp[3] = 2; dp[4] = 2; dp[6] = 2; dp[0] = 0;
        for(int i=8;i<=N;++i)
        {
            for(int j=0;j<4;++j)
            {
                dp[i] = Math.min(dp[i],dp[i-coin[j]]+1);
            }
        }
        bw.write(dp[N]+"");
        bw.close();
    }

}
