import java.io.*;
import java.util.StringTokenizer;

public class Main2357
{
    static Mm[] tree;
    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        tree = new Mm[4*(N+1)];
        for(int i=1;i<=N;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1,1,N);
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Mm mm = query(1,1,N,a,b);
            bw.write(mm.min+" "+mm.max+"\n");
        }
        bw.close();
    }
    public static Mm init(int node, int start, int end)
    {
        if(start==end)
        {
            return tree[node] = new Mm(arr[start],arr[start]);
        }
        int mid = (start+end)/2;
        Mm mm1 = init(node*2,start,mid);
        Mm mm2 = init(node*2+1,mid+1,end);
        return tree[node] = new Mm(Math.max(mm1.max,mm2.max), Math.min(mm1.min,mm2.min));
    }
    public static Mm query(int node, int start, int end, int left, int right)
    {
        if(right<start || end<left)
            return new Mm(Integer.MIN_VALUE,Integer.MAX_VALUE);
        if(left<=start && end<=right)
            return tree[node];
        int mid = (start+end)/2;
        Mm mm1 = query(node*2,start,mid,left,right);
        Mm mm2 = query(node*2+1,mid+1,end,left,right);
        return new Mm(Math.max(mm1.max,mm2.max), Math.min(mm1.min,mm2.min));
    }
}
class Mm
{
    int min;
    int max;
    Mm(int max, int min)
    {
        this.max = max;
        this.min = min;
    }
}
