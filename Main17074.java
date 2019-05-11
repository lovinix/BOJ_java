import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main398_3
{
    static int[] dp;
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        if(N==2)
        {
            System.out.print(2);
            return;
        }
        dp = new int[N];
        Arrays.fill(dp,-1);
        dp[N-1] = 1;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = true;
        int ans = 0;
        recv(0);
        for(int i=1;i<N-1;++i)
        {
            if(flag == false)
                break;
            if(dp[i+1]==1 && arr[i-1]<=arr[i+1]) ans++;
            if(arr[i]<arr[i-1]) flag=false;
        }
        if(dp[1]==1) ans++;
        if(flag) ans++;
        bw.write(ans+"");
        bw.close();
    }
    public static boolean recv(int idx)
    {
        if(idx>=N) return true;
        if(dp[idx]==0) return false;
        if(dp[idx]==1) return true;
        boolean next = recv(idx+1);
        if(next)
        {
            if(arr[idx]<=arr[idx+1])
            {
                dp[idx] = 1;
                return true;
            }
            else
            {
                dp[idx] = 0;
                return false;
            }
        }
        else
        {
            dp[idx] = 0;
            return false;
        }
    }
}
