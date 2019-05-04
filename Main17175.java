import java.io.*;

public class Main408_3
{
    static int[] dp = new int[51];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for(int i=4;i<=50;++i)
        {
            dp[i] = (dp[i-1]+dp[i-2]+1)%1000000007;
        }
        bw.write(dp[Integer.parseInt(br.readLine())]+"");
        bw.close();
    }

}
