import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11403
{
    static int[][] arr;
    static boolean[][] ans;
    static boolean[] isVisited;
    static int N;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = new boolean[N][N];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;++i)
        {
            isVisited = new boolean[N];
            q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty())
            {
                int cur = q.poll();
                for(int j=0;j<N;++j)
                {
                    if(arr[cur][j]==0) continue;
                    if(isVisited[j]) continue;
                    isVisited[j] = true;
                    q.offer(j);
                }
            }
            for(int j=0;j<N;++j)
                ans[i][j] = isVisited[j];
        }
        for(int i=0;i<N;++i)
        {
            for(int j=0;j<N;++j)
            {
                bw.write(ans[i][j]?"1 ":"0 ");
            }
            bw.write("\n");
        }
        bw.close();
    }

}
