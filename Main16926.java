import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main16926
{
    static Deque<Integer>[] deques;
    static int[][] arr;
    static int N,M;
    static int[][] ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int num = Math.min(N,M)/2;
        arr = new int[N][M];
        ans = new int[N][M];
        deques = new Deque[num];
        for(int i=0;i<num;++i)
        {
            deques[i] = new LinkedList<>();
        }
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<num;++i)
        {
            app(i);
        }
        for(int i=0;i<num;++i)
        {
            int r = R%(N*M);
            while(r-->0)
            {
                deques[i].add(deques[i].poll());
            }
        }
        for(int i=0;i<num;++i)
        {
            dep(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;++i)
        {
            for(int j=0;j<M;++j)
            {
                sb.append(ans[i][j]+"");
                if(j!=M-1) sb.append(" ");
            }
            if(i!=N-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
    public static void app(int n)
    {
        for(int i=n;i<M-n;++i)
        {
            deques[n].add(arr[n][i]);
        }
        for(int i=n+1;i<N-n;++i)
        {
            deques[n].add(arr[i][M-1-n]);
        }
        for(int i=M-2-n;i>=n;--i)
        {
            deques[n].add(arr[N-1-n][i]);
        }
        for(int i=N-2-n;i>n;--i)
        {
            deques[n].add(arr[i][n]);
        }
    }
    public static void dep(int n)
    {
        for(int i=n;i<M-n;++i)
        {
            ans[n][i] = deques[n].poll();
        }
        for(int i=n+1;i<N-n;++i)
        {
            ans[i][M-1-n] = deques[n].poll();
        }
        for(int i=M-2-n;i>=n;--i)
        {
            ans[N-1-n][i] = deques[n].poll();
        }
        for(int i=N-2-n;i>n;--i)
        {
            ans[i][n] = deques[n].poll();
        }
    }
}
