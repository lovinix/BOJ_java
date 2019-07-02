import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206
{
    static boolean[][][] isvisited;
    static char[][] arr;
    static Queue<Node> q;
    static int N,M;
    static int[] dn={-1,1,0,0},dm={0,0,-1,1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        isvisited = new boolean[N][M][2];
        for(int i=0;i<N;++i)
        {
            arr[i] = br.readLine().toCharArray();
        }
        q = new LinkedList<>();
        q.offer(new Node(0,0,1,1));
        while(!q.isEmpty())
        {
            Node cur = q.poll();
            if((cur.n == N-1)&&(cur.m == M-1))
            {
                System.out.print(cur.d);
                return;
            }
            for(int j=0;j<2;++j)
            {
                if(j==1 && cur.f==0) continue;
                for(int i=0;i<4;++i)
                {
                    int nextn = cur.n+dn[i];
                    int nextm = cur.m+dm[i];
                    int nextf = cur.f-j;
                    if(nextn<0 || nextm<0 || nextn>=N || nextm>=M) continue;
                    if((j^(arr[nextn][nextm]-'0'))==1) continue;
                    if(isvisited[nextn][nextm][j]) continue;
                    isvisited[nextn][nextm][j] = true;
                    q.offer(new Node(nextn,nextm,cur.d+1,nextf));
                }
            }
        }
        bw.write("-1");
        bw.close();
    }

}
class Node
{
    int n,m,d,f;
    Node(int _n,int _m, int _d, int _f)
    {
        n=_n;m=_m;d=_d;f=_f;
    }
}