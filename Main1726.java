import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1726
{
    static int[][] arr;
    static int N, M;
    static boolean[][] isVisited;
    static PriorityQueue<Robot> pq;
    static int[] dn = {0, 1, 0, -1}; // eswn
    static int[] dm = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int tmp;
        pq.offer(new Robot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, (tmp = Integer.parseInt(st.nextToken()) - 1) == 1 ? 2 : tmp == 2 ? 1 : tmp, 0));
        st = new StringTokenizer(br.readLine());
        int tn = Integer.parseInt(st.nextToken()) - 1;
        int tm = Integer.parseInt(st.nextToken()) - 1;
        int tdir = Integer.parseInt(st.nextToken()) - 1;
        tdir = tdir==1?2:tdir==2?1:tdir;
        int ans = 0;
        while (!pq.isEmpty())
        {
            Robot cur = pq.poll();
            if (cur.n == tn && cur.m == tm)
            {
                ans = cur.d + (Math.abs(tdir - cur.dir)==3?1: Math.abs(tdir-cur.dir));
                break;
            }
            for (int i = 0; i < 4; ++i)
            {
                loop:
                for (int j = 3; j >= 1; --j)
                {
                    int nextn = cur.n + dn[i] * j;
                    int nextm = cur.m + dm[i] * j;
                    if (nextn < 0 || nextm < 0 || nextn >= N || nextm >= M) continue;
                    for (int k = cur.n; k != nextn; k += dn[i])
                    {
                        if (arr[k][nextm] == 1) continue loop;
                    }
                    for (int k = cur.m; k != nextm; k += dm[i])
                    {
                        if (arr[nextn][k] == 1) continue loop;
                    }
                    if (arr[nextn][nextm] == 1) continue;
                    if (isVisited[nextn][nextm]) continue;
                    isVisited[nextn][nextm] = true;
                    pq.offer(new Robot(nextn, nextm, i, cur.d + (Math.abs(i - cur.dir)==3?1: Math.abs(i-cur.dir)) + 1));
                }
            }
        }
        bw.write(ans + "");
        bw.close();
    }

}

class Robot implements Comparable<Robot>
{
    int n, m, dir, d;

    Robot(int n, int m, int dir, int d)
    {
        this.n = n;
        this.m = m;
        this.dir = dir;
        this.d = d;
    }

    public int compareTo(Robot r)
    {
        return this.d - r.d;
    }
}