import java.io.*;

public class Main2156
{
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp =new int[n][2];
        for(int i=0;i<n;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(n==1)
        {
            bw.write(arr[0]+"");
            bw.close();
            return;
        }
        dp[0][0]=0;
        dp[0][1]=arr[0];
        dp[1][1]=dp[0][1]+arr[1];
        dp[1][0]=dp[0][1];
        for(int i=2;i<n;++i)
        {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][0]+arr[i],dp[i-2][0]+arr[i-1]+arr[i]);
        }
        bw.write(Math.max(dp[n-1][0],dp[n-1][1])+"");
        bw.close();
    }
}
