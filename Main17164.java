import java.io.*;
import java.util.Arrays;

public class Main421_1
{
    static char[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        dp = new int[N];
        Arrays.fill(dp,-1);
        int ans = -1;
        for(int i=0;i<arr.length;++i)
        {
            ans = Math.max(ans,recv(i));
        }
        bw.write(ans+"");
        bw.close();
    }
    public static int recv(int idx)
    {
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int ret = 1;
        char cur = arr[idx];
        if(cur=='V') return 1;
        if(idx==arr.length-1||(cur=='R'&&arr[idx+1]=='B')||cur=='B'&&arr[idx+1]=='R')
        {
            ret = Math.max(ret,recv(idx+1)+1);
        }
        dp[idx]=ret;
        return ret;
    }
}
