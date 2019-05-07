import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17182
{
    static int[][] arr;
    static int[][] dist;
    static PriorityQueue<Asdf> pq;
    static int min = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static int[] result;
    static int N,K;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        dist = new int[N][N];
        isVisited = new boolean[N];
        result = new int[N];
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;++i)
        {
            pq = new PriorityQueue<>();
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            pq.offer(new Asdf(i,0));
            while(!pq.isEmpty())
            {
                Asdf asdf = pq.poll();
                for(int j=0;j<N;++j)
                {
                    if(i==j) continue;
                    if(dist[i][j]<=asdf.d+arr[asdf.cur][j]) continue;
                    dist[i][j] = asdf.d+arr[asdf.cur][j];
                    pq.offer(new Asdf(j,asdf.d+arr[asdf.cur][j]));
                }
            }
        }
        recv(0);
        bw.write(min+"");
        bw.close();
    }

    public static void recv(int cnt)
    {
        if(cnt==0)
        {
            result[cnt] = K;
            isVisited[K] = true;
            recv(cnt+1);
        }
        else if( cnt<N)
        {
            for(int i=0;i<N;++i)
            {
                if(!isVisited[i])
                {
                    isVisited[i] = true;
                    result[cnt] = i;
                    recv(cnt+1);
                    isVisited[i] = false;
                }
            }
        }
        else
        {
            int sum = 0;
            for(int i=1;i<N;++i)
            {
                sum+=dist[result[i-1]][result[i]];
            }
            min = Math.min(sum,min);
        }
    }
}

class Asdf implements Comparable<Asdf>
{
    int cur;
    int d;

    Asdf(int cur,int d)
    {
        this.cur = cur;
        this.d = d;
    }
    public int compareTo(Asdf asdf)
    {
        return this.d-asdf.d;
    }

}
