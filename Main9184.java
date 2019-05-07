import java.io.*;
import java.util.StringTokenizer;

public class Main9184
{
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while (!(s=br.readLine()).equals("-1 -1 -1"))
        {
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bw.write("w("+a+", "+b+", "+c+") = "+recv(a,b,c)+"\n");
        }
        bw.close();
    }

    public static int recv(int a, int b, int c)
    {
        if(a<=0 || b<=0 || c<=0)
            return 1;
        if( a>20 || b>20 || c>20)
            return recv(20, 20, 20);
        if(dp[a][b][c] != 0)
            return dp[a][b][c];
        int ret;
        if(a<b && b<c)
        {
            ret = recv(a,b,c-1) + recv(a,b-1,c-1) - recv(a,b-1,c);
        }
        else
        {
            ret =recv(a - 1, b, c) + recv(a - 1, b - 1, c) + recv(a - 1, b, c - 1) - recv(a - 1, b - 1, c - 1);
        }
        dp[a][b][c] = ret;
        return ret;
    }
}
