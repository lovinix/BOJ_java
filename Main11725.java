import java.io.*;
import java.util.*;

public class Main11725
{
    static ArrayList<Integer>[] list;
    static Queue<Integer> q;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0;i<=n;++i)
        {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int[] p = new int[n+1];
        q = new LinkedList<>();
        q.offer(1);
        isVisited = new boolean[n+1];
        isVisited[1] = true;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(int i : list[cur])
            {
                if(isVisited[i]==true) continue;
                p[i] = cur;
                isVisited[i] = true;
                q.offer(i);
            }
        }
        for(int i=2;i<=n;++i)
        {
            bw.write(p[i]+"\n");
        }
        bw.close();
    }
}
