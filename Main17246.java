import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17246
{
    static int[][] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for(int i=0;i<=N;++i)
        {
            Arrays.fill(arr[i],10000);
        }
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr[a][b] = k;
            arr[b][a] = k;
        }
        for(int k=1;k<=N;++k)
        {
            for(int i=1;i<=N;++i)
            {
                for(int j=1;j<=N;++j)
                {
                    if(arr[i][k] + arr[k][j] < arr[i][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(arr[x][y]==10000?"-1\n":(arr[x][y]+"\n"));
        }
        bw.close();
    }

}
