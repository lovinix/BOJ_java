import java.io.*;
import java.util.StringTokenizer;

public class Main427_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            max = Math.max(max,Integer.parseInt(st.nextToken()));
        }
        bw.write(max+"");
        bw.close();
    }
}
