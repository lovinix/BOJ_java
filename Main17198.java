import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main17198
{
    static char[][] arr = new char[10][10];
    static boolean[][] isvisited = new boolean[10][10];
    static Queue<Point2> q = new ArrayDeque<>();
    static int ansn,ansm;
    static int[] dn={1,-1,0,0},dm={0,0,1,-1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<10;++i)
        {
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<10;++j)
            {
                if(arr[i][j] == 'B')
                    q.offer(new Point2(i,j,0));
                else if(arr[i][j] == 'L')
                {
                    ansn = i;
                    ansm = j;
                }

            }
        }
        while(!q.isEmpty())
        {
            Point2 cur = q.poll();
            if(cur.n==ansn && cur.m==ansm)
            {
                bw.write(cur.d-1+"");
                break;
            }
            for(int i=0;i<4;++i)
            {
                int nextn = cur.n+dn[i];
                int nextm = cur.m+dm[i];
                if(nextn<0 ||nextm<0 || nextn>=10|| nextm>=10) continue;
                if(arr[nextn][nextm]=='R') continue;
                if(isvisited[nextn][nextm]) continue;
                isvisited[nextn][nextm] = true;
                q.offer(new Point2(nextn,nextm,cur.d+1));
            }
        }

        bw.close();
    }

}
class Point2
{
    int n,m,d;
    Point2(int n,int m,int d)
    {
        this.n = n;this.m=m;this.d=d;
    }
}