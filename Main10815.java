import java.io.*;
import java.util.StringTokenizer;

public class Main10815
{
    static int cnt[] = new int[20000001];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
            cnt[Integer.parseInt(st.nextToken())+10000000]++;
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i)
        {
            bw.write(cnt[Integer.parseInt(st.nextToken())+10000000]>0?"1 ":"0 ");
        }
        bw.close();
    }

}
