import java.io.*;
import java.util.StringTokenizer;

public class Main16395
{
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[1][0] = 1; dp[1][1] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bw.write(recv(n-1,k-1)+"");
        bw.close();
    }
    public static int recv(int n, int r)
    {
        if(n==r || r==0) return 1;
        return dp[n][r] = recv(n-1,r-1)+recv(n-1,r);
    }
}
