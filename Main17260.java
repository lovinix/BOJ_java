import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17260
{
    static ArrayList<Integer>[] arr;
    static int N,K;
    static PriorityQueue<State> pq;
    static int[] h;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new ArrayList[N+1];
        h = new int[N+1];
        isVisited = new boolean[N+1];
        for(int i=0;i<=N;++i)
            arr[i] = new ArrayList<>();
        for(int i=1;i<=N;++i)
            h[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N-1;++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        pq = new PriorityQueue<>();
        for(int i=1;i<=N;++i)
        {
            if(i!=K)
                pq.offer(new State(i,h[i]));
        }
        while(!pq.isEmpty())
        {
            State cur = pq.poll();
            for(int next : arr[cur.num])
            {
                if(isVisited[next]) continue;
                if(cur.h<h[next]) continue;
                if(next==K)
                {
                    System.out.print("1");
                    return;
                }
                pq.offer(new State(next,(cur.h-h[next])/2+h[next]));
                isVisited[next] = true;
            }
        }
        bw.write("0");
        bw.close();
    }

}
class State implements Comparable<State>
{
    int num;
    int h;
    State(int num, int h)
    {
        this.num = num; this.h = h;
    }
    public int compareTo(State state)
    {
        return state.h-h;
    }
}