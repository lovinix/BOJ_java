import java.io.*;
import java.util.StringTokenizer;

public class Main1018
{
    static char[][] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i=0;i<N;++i)
        {
            arr[i] = br.readLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=N-8;++i)
        {
            for(int j=0;j<=M-8;++j)
            {
                min = Math.min(min,getNum(i,j));
            }
        }
        bw.write(min+"");
        bw.close();
    }

    public static int getNum(int n,int m)
    {
        char[] c = {arr[n][m],arr[n][m]=='W'?'B':'W'};
        int sum = 0;
        int k = 0;
        for(int i=n;i<n+8;++i)
        {
            for(int j=m;j<m+8;++j)
            {
                sum+=arr[i][j]==c[k]?0:1;
                k^=1;
            }
            k^=1;
        }
        return Math.min(sum,64-sum);
    }
}
