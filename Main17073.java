import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main398_2
{
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        for(int i=0;i<=N;++i)
        {
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        double leaf=0;
        for(int i=2;i<=N;++i)
        {
            if(arr[i].size()==1) leaf++;
        }
        bw.write(W/leaf+"");
        bw.close();
    }

}
