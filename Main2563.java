import java.io.*;
import java.util.StringTokenizer;

public class Main2563
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r= Integer.parseInt(st.nextToken());
            for(int n=r;n<r+10;++n)
            {
                for(int m=c;m<c+10;++m)
                {
                    arr[n][m] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<100;++i)
        {
            for (int j = 0; j < 100; ++j)
            {
                ans+=arr[i][j];
            }
        }
        bw.write(ans+"");
        bw.close();
    }
}
