import java.io.*;
import java.util.Arrays;

public class Main424_4
{
    static int N,M;
    static int[] arr;
    static int count;
    static int[][] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][M+1];
        for(int i=0;i<N;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        bw.write(recv(N-1,M)+"");
        bw.close();
    }
    public static int recv(int idx,int sum)
    {
        if(idx<0 || sum<0) return 0;
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        if(idx==0)
        {
            if(sum>0)
                return 1;
            else
                return 0;
        }
        else
        {
            int s = 0;
            for(int i=1;i<sum;++i)
            {
                s+=recv(idx-1,i);
            }
            return dp[idx][sum] = s;
        }
    }

}
