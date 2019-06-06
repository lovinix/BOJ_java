import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static char[][] arr;
    static int N,M,L,R,ans;
    static int[] dn = {-1,1,0,0};
    static int[] dm = {0,0,1,-1};
    static Queue<Co17267> q = new LinkedList<>();
    static int[][] isVisited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        isVisited = new int[N][M];
        for(int i=0;i<N;++i)
            Arrays.fill(isVisited[i],-1);
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;++i)
        {
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<M;++j)
            {
                if(arr[i][j]=='2')
                {
                    isVisited[i][j] = L+R;
                    q.offer(new Co17267(i, j, L, R));
                }
            }
        }
        while(!q.isEmpty())
        {
            Co17267 cur = q.poll();
            for(int i=0;i<4;++i)
            {
                int nextn = cur.n+dn[i]; int nextm = cur.m+dm[i];
                if(nextn<0 || nextm<0 || nextn>=N || nextm>=M) continue;
                if(arr[nextn][nextm]=='1') continue;
                if(i==2 && cur.r==0) continue;
                if(i==3 && cur.l==0) continue;
                if(isVisited[nextn][nextm]>=cur.l+cur.r) continue;
                isVisited[nextn][nextm] = cur.l+cur.r;
                q.offer(new Co17267(nextn,nextm,i==3?cur.l-1:cur.l,i==2?cur.r-1:cur.r));
            }
        }
        for(int i=0;i<N;++i)
        {
            for(int j=0;j<M;++j)
            {
                if(isVisited[i][j]>-1) ans++;
            }
        }
        bw.write(ans+"");
        bw.close();
    }
}
class Co17267
{
    int n,m,l,r;
    Co17267(int n,int m, int l, int r)
    {
        this.n = n; this.m = m; this.l =l; this.r = r;
    }
}
