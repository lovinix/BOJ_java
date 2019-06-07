import java.io.*;
import java.util.StringTokenizer;

public class Main17271
{
    static int N,B;
    static int[] dp = new int[10101];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;++i)
        {
            dp[i+1]++;
            dp[i+B]++;
        }
        bw.write(dp[N]+"");
        bw.close();
    }
}
