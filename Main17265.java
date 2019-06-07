import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17265
{
    static char[][] arr;
    static int[][][] dp;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        dp = new int[N][N][2];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j)
            {
                arr[i][j] = st.nextToken().charAt(0);
                Arrays.fill(dp[i][j],12345678);
            }
        }
        dp[0][0][0] = dp[0][0][1] = arr[0][0]-'0';
        recv(N-1,N-1);
        bw.write(dp[N-1][N-1][1]+" "+dp[N-1][N-1][0]);
        bw.close();
    }
    public static int cal(int v1, int v2, char op)
    {
        switch (op)
        {
            case '+' : return v1+v2;
            case '-' : return v1-v2;
            case '*' : return v1*v2;
        }
        return 0;
    }
    public static int[] recv(int n, int m)
    {
        if(dp[n][m][0]!=12345678) return dp[n][m];
        if(arr[n][m]>='0' && arr[n][m]<='5')
        {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            if(n>0)
            {
                min = Math.min(min, cal(recv(n-1,m)[0],arr[n][m]-'0',arr[n-1][m]));
                max = Math.max(max, cal(recv(n-1,m)[1],arr[n][m]-'0',arr[n-1][m]));
            }
            if(m>0)
            {
                min = Math.min(min, cal(recv(n,m-1)[0],arr[n][m]-'0',arr[n][m-1]));
                max = Math.max(max,cal(recv(n,m-1)[1],arr[n][m]-'0',arr[n][m-1]));
            }
            dp[n][m][0] = min;
            dp[n][m][1] = max;
            return dp[n][m];
        }
        else
        {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            if(n>0)
            {
                min = Math.min(min, recv(n-1,m)[0]);
                max = Math.max(max, recv(n-1,m)[1]);
            }
            if(m>0)
            {
                min = Math.min(min, recv(n,m-1)[0]);
                max = Math.max(max, recv(n,m-1)[1]);
            }
            dp[n][m][0] = min;
            dp[n][m][1] = max;
            return dp[n][m];
        }
    }
}
