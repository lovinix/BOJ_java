import java.io.*;
import java.util.*;

public class Main1238
{
    static int[] dist;
    static int[] dist2;
    static ArrayList<ArrayList<Adj>> arrayList;
    static ArrayList<ArrayList<Adj>> arrayList2;
    static PriorityQueue<Dijk> pq;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        arrayList = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
        {
            arrayList.add(new ArrayList<>());
        }

            Arrays.fill(dist, Integer.MAX_VALUE);


        for (int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(new Adj(b, c));
        }

        pq = new PriorityQueue<>();
        pq.offer(new Dijk(X, 0));
        while (!pq.isEmpty())
        {
            Dijk dijk = pq.poll();
            dist[dijk.cur] = Math.min(dist[dijk.cur], dijk.d);

            for (Adj adj : arrayList.get(dijk.cur))
            {
                if (dist[adj.to] <= dijk.d + adj.d) continue;
                dist[adj.to] = dijk.d + adj.d;
                pq.offer(new Dijk(adj.to, dijk.d + adj.d));
            }
        }
        arrayList2 = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
        {
            arrayList2.add(new ArrayList<>());
        }
        for(int i=1;i<=N;++i)
        {
            for(Adj adj : arrayList.get(i))
            {
                arrayList2.get(adj.to).add(new Adj(i,adj.d));
            }
        }
        dist2 = new int[N+1];
        Arrays.fill(dist2,Integer.MAX_VALUE);
        pq = new PriorityQueue<>();
        pq.offer(new Dijk(X, 0));
        while (!pq.isEmpty())
        {
            Dijk dijk = pq.poll();
            dist2[dijk.cur] = Math.min(dist2[dijk.cur], dijk.d);

            for (Adj adj : arrayList2.get(dijk.cur))
            {
                if (dist2[adj.to] <= dijk.d + adj.d) continue;
                dist2[adj.to] = dijk.d + adj.d;
                pq.offer(new Dijk(adj.to, dijk.d + adj.d));
            }
        }

        for(int i=1;i<=N;++i)
        {
            if(i==X) continue;
            max = Math.max(dist[i]+dist2[i],max);
        }
        bw.write(max + "");
        bw.close();
    }

}

class Dijk implements Comparable<Dijk>
{
    int cur;
    int d;

    Dijk(int cur, int d)
    {
        this.cur = cur;
        this.d = d;
    }

    public int compareTo(Dijk dijk)
    {
        return this.d - dijk.d;
    }
}

class Adj
{
    int to;
    int d;

    Adj(int to, int d)
    {
        this.to = to;
        this.d = d;
    }
}