import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2406
{
    static int[] parent;
    static int N,M,sum,num;
    static PriorityQueue<Edge2406> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<=N;++i) parent[i] = i;
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            merge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
        }
        if(num == N-2)
        {
            System.out.print("0 0");
            return;
        }
        int pre = num;
        sb = new StringBuilder();
        sum = 0;
        for(int i=1;i<=N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;++j)
            {
                if(i==1||j==1||(i<=j))
                {
                    st.nextToken();
                    continue;
                }
                pq.offer(new Edge2406(i,j,Integer.parseInt(st.nextToken())));
            }
        }
        while(num<N-2)
        {
            Edge2406 edge = pq.poll();
            merge(edge.x,edge.y,edge.d);
        }
        bw.write(sum+" "+(num-pre)+"\n");
        bw.write(sb.toString());
        bw.close();
    }
    public static int find(int u)
    {
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    public static void merge(int u, int v, int d)
    {
        int a = u; int b = v;
        u = find(u); v = find(v);
        if(u==v) return;
        parent[v] = u;
        num++;
        sum+=d;
        sb.append(a+" "+b+"\n");
    }
}
class Edge2406 implements Comparable<Edge2406>
{
    int x,y,d;
    Edge2406(int x,int y,int d)
    {
        this.x=x;this.y=y;this.d=d;
    }
    public int compareTo(Edge2406 edge2406)
    {
        return this.d-edge2406.d;
    }
}