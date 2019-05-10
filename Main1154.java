import java.io.*;
import java.util.StringTokenizer;

public class Main1154
{
    static boolean[][] arr;
    static boolean[] team;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        if (N == 1)
        {
            System.out.print("-1");
            return;
        }
        arr = new boolean[N + 1][N + 1];
        team = new boolean[N+1];
        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            arr[a][b] = true;
            arr[b][a] = true;
        }
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 1; i <= N; ++i)
        {
            int n = 0;
            for (int j = 1; j <= N; ++j)
            {
                if (arr[i][j]) n++;
            }
            if (min > n)
            {
                min = n;
                idx = i;
            }
        }
        if(min == N-1)
        {
            bw.write("1\n1 -1\n");
            for(int i=2;i<=N;++i)
                bw.write(i+ " ");
            bw.write("-1\n");
            bw.close();
            return;
        }
        int r = idx;
        for(int i=1;i<=N;++i)
        {
            if(idx!=i && !arr[idx][i])
            {
                r = i;
                break;
            }
        }
        for (int i = 1; i <= N; ++i)
        {
            if (i == r || i == idx || arr[idx][i]) continue;
            if (!arr[r][i])
            {
                System.out.print("-1");
                return;
            }
        }
        bw.write("1\n1 ");
        for(int i=1;i<=N;++i)
        {
            if(arr[1][i])
            {
                bw.write(i + " ");
                team[i] = true;
            }
        }
        bw.write("-1\n");
        for(int i=2;i<=N;++i)
        {
            if(arr[r][i]&&!team[i] || i==r)
                bw.write(i + " ");
        }
        bw.write("-1\n");
        bw.close();
    }
}
