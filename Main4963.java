import java.io.*;
import java.util.StringTokenizer;

public class Main4963
{
    static int[][] arr;
    static int N, M;
    static boolean[][] isVisited;
    static int[] dn = {0,1,1,1,0,-1,-1,-1};
    static int[] dm = {1,1,0,-1,-1,-1,0,1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
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
            int count = 0;
            for(int i=0;i<N;++i)
            {
                for(int j=0;j<M;++j)
                {
                    if(arr[i][j] == 1 && isVisited[i][j] == false)
                    {
                        count++;
                        recv(i,j);
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.close();
    }
    public static void recv(int n, int m)
    {
        if(isVisited[n][m]) return;
        isVisited[n][m] = true;
        for(int i=0;i<8;++i)
        {
            int nextn = n+dn[i];
            int nextm = m+dm[i];
            if(nextn<0 || nextm<0 || nextn>=N || nextm>=M) continue;
            if(arr[nextn][nextm]!=1) continue;
            if(isVisited[nextn][nextm]) continue;
            recv(nextn,nextm);
        }
    }
}
