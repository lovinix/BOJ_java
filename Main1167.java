import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1167
{
    static ArrayList<Edge1>[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=0;i<=N;++i)
            arr[i] = new ArrayList<>();
        for(int i=1;i<=N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next;
            while((next=Integer.parseInt(st.nextToken()))!=-1)
            {
                int w = Integer.parseInt(st.nextToken());
                arr[cur].add(new Edge1(next,w));
            }
        }

        bw.close();
    }

}
class Edge1
{
    int v,w;
    Edge1(int v, int w)
    {
        this.v=v;this.w=w;
    }
}