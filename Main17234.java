import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17234
{
    static int n,a,b;
    static int[] dp;
    static final int MAX = 1000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        dp = new int[n+a+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        bw.close();
    }

    public static int recv(int k)
    {
        if(k<0) return MAX;
        if(dp[k]!=-1) return dp[k];
        return 1;
    }
}
