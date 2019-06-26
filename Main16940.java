import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16940
{
    static ArrayList<Integer>[] arr;
    static boolean[][] isvisited;
    static Queue<Integer> q = new ArrayDeque<>();
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        isvisited = new boolean[N+1][N+1];
        for(int i=0;i<N-1;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(!st.nextToken().equals("1"))
        {
            System.out.print(0);
            return;
        }
        q.offer(1);
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(int i=0;i<arr[cur].size();++i)
            {

            }
        }
        bw.close();
    }

}
