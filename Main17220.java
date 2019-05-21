import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17220
{
    static boolean[][] arr;
    static boolean[] isroot;
    static boolean[] isvisited;
    static int ans,N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][N];
        isroot = new boolean[N];
        Arrays.fill(isroot,true);
        isvisited = new boolean[N];
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            arr[p-'A'][c-'A'] = true;
            isroot[c-'A'] = false;
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        while(st.hasMoreElements())
        {
            int c = st.nextToken().charAt(0)-'A';
            for(int i=0;i<N;++i)
                arr[i][c] = false;
            for(int i=0;i<N;++i)
                arr[c][i] = false;
        }
        for(int i=0;i<N;++i)
        {
            if(!isroot[i]) continue;
            recv(i);
        }
        bw.write(ans+"");
        bw.close();
    }
    public static void recv(int j)
    {
        if(isvisited[j]) return;
        isvisited[j] = true;
        for(int i=0;i<N;++i)
        {
            if(i==j) continue;
            if(isvisited[i]) continue;
            if(!arr[j][i]) continue;
            ans++;
            recv(i);
        }
    }
}
