import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1577
{
    static long[][] dp;
    static int N,M;
    static int[][] con;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[M+1][N+1];
        for(int i=0;i<=M;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        dp[0][0] = 1;
        con = new int[M+1][N+1];
        int K =Integer.parseInt(br.readLine());
        for(int i=0;i<K;++i)
        {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            if(n1==n2)
                con[Math.max(m1,m2)][n1] = (con[Math.max(m1,m2)][n1]==1||con[Math.max(m1,m2)][n1]==3)?3:2;// left
            else if (m1 == m2)
                con[m1][Math.max(n1,n2)] = (con[m1][Math.max(n1,n2)]==2||con[m1][Math.max(n1,n2)]==3)?3:1; // down
        }
        bw.write(recv(M,N)+"");
        bw.close();
    }

    public static long recv(int m,int n)
    {
        if(n<0||m<0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        long ret = 0;
        if(con[m][n]==3)
        {
            dp[m][n] = 0; return 0;
        }
        if(con[m][n]!=1) ret += recv(m,n-1);
        if(con[m][n]!=2) ret += recv(m-1,n);
        dp[m][n] = ret;
        return ret;
    }
}
