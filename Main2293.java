import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2293
{
    static int[] dp = new int[10001];
    static int[] arr;
    static int n,k;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0;i<n;++i)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.fill(dp,-1);
        dp[0] = 1;
        bw.write(recv(k)+"");
        bw.close();
    }
    public static int recv(int cur)
    {
        if(cur<0) return 0;
        if(dp[cur]!=-1) return dp[cur];
        dp[cur] = 0;
        for(int i : arr)
            dp[cur]+=recv(cur-i);
        return dp[cur];
    }
}
