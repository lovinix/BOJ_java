import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2163
{
    static int[][] dp;
    static int N, M;
    static final int MAX = 301;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[MAX][MAX];
        for(int i=0;i<=N;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        dp[1][1] = 0;
        dp[1][2] = 1;
        dp[2][1] = 1;
        bw.write(recv(N,M)+"");
        bw.close();
    }
    public static int recv(int n,int m)
    {
        if(dp[n][m]!=-1) return dp[n][m];
        int ret = Integer.MAX_VALUE;
        for(int i=1;i<n;++i)
        {
            ret = Math.min(ret,recv(n-i,m)+recv(i,m)+1);
        }
        for(int i=1;i<m;++i)
        {
            ret = Math.min(ret,recv(n,m-i)+recv(n,i)+1);
        }
        dp[n][m] = ret;
        return ret;
    }
}
