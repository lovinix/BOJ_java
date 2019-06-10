import java.io.*;
import java.util.StringTokenizer;

public class Main11659
{
    static long[] arr,sum;
    static int N,M;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N+1]; sum = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i)
        {
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i-1]+arr[i];
        }
        for(int i=0;i<M;++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(sum[b]-sum[a-1]+"\n");
        }
        bw.close();
    }

}
