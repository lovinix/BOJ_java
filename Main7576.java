import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576
{
    static int[] dn = {-1,0,0,1};
    static int[] dm = {0,1,-1,0};
    static int N,M;
    static int[][] arr;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        isVisited = new boolean[N][M];
        Queue<Lo> q = new LinkedList<>();
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                {
                    q.offer(new Lo(i,j,0));
                    isVisited[i][j] = true;
                }
            }
        }
        int min = -1;
        while(!q.isEmpty())
        {
            Lo cur = q.poll();
            min = Math.max(cur.d,min);
            for(int i=0;i<4;++i)
            {
                int nextn = cur.n+dn[i];
                int nextm = cur.m+dm[i];
                if(nextn<0||nextn>=N||nextm<0||nextm>=M) continue;
                if(arr[nextn][nextm]==-1) continue;
                if(isVisited[nextn][nextm]) continue;
                isVisited[nextn][nextm] = true;
                q.offer(new Lo(nextn,nextm,cur.d+1));
            }
        }
        for(int i=0;i<N;++i)
        {
            for(int j=0;j<M;++j)
            {
                if(arr[i][j]==1 || arr[i][j]==-1) continue;
                if(isVisited[i][j]) continue;
                bw.write("-1");
                bw.close();
                return;
            }
        }
        bw.write(min+"");
        bw.close();
    }
}
class Lo
{
    int n;
    int m;
    int d;
    Lo(int n,int m,int d)
    {
        this.n = n;
        this.m = m;
        this.d = d;
    }

}

