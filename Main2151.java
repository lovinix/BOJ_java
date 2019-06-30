import java.io.*;
import java.util.PriorityQueue;

public class Main2151
{
    static int[] dn={0,1,0,-1},dm={1,0,-1,0}; // rdlu
    static int N, ansn, ansm;
    static char[][] arr;
    static PriorityQueue<Ptr> pq = new PriorityQueue<>();
    static boolean[][][] isvisited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        isvisited = new boolean[N][N][4];
        boolean flag = true;
        for(int i=0;i<N;++i)
        {
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<N;++j)
            {
                if(arr[i][j]=='#')
                {
                    if(flag)
                    {
                        for(int k=0;k<4;++k)
                            pq.offer(new Ptr(i,j,k,0));
                        flag = false;
                    }
                    else
                    {
                        ansn = i; ansm = j;
                    }
                }
            }
        }
        while(!pq.isEmpty())
        {
            Ptr cur = pq.poll();
            if(cur.n == ansn && cur.m == ansm)
            {
                bw.write(cur.s+"");
                bw.close();
                return;
            }
            for(int i=-1;i<=1;++i)
            {
                if(i!=0 && arr[cur.n][cur.m]!='!') continue;
                int nextd = (cur.d+i+4)%4;
                int nextn = cur.n+dn[nextd], nextm = cur.m+dm[nextd];
                if(nextn<0 || nextm<0 || nextn>=N || nextm>=N) continue;
                if(isvisited[nextn][nextm][nextd]) continue;
                if(arr[nextn][nextm] == '*') continue;
                isvisited[nextn][nextm][nextd] = true;
                pq.offer(new Ptr(nextn,nextm,nextd,i==0?cur.s:cur.s+1));
            }
        }
    }

}
class Ptr implements Comparable<Ptr>
{
    int n,m,d,s;
    Ptr(int n,int m,int d, int s)
    {
        this.n=n;this.m=m;this.d=d;this.s=s;
    }
    public int compareTo(Ptr ptr)
    {
        return this.s-ptr.s;
    }
}
