import java.io.*;
import java.util.StringTokenizer;

public class Main11055
{
    static int[] arr,dp;
    static int N,ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i=1;i<N;++i)
        {
            dp[i] = arr[i];
            for(int j=0;j<i;++j)
            {
                if(arr[i]<=arr[j]) continue;
                dp[i] = Math.max(dp[i],dp[j]+arr[i]);
            }
        }
        for(int i : dp)
            ans = Math.max(ans,i);
        bw.write(ans+"");
        bw.close();
    }
}
