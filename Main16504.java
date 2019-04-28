import java.io.*;
import java.util.StringTokenizer;

public class Main16504
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());
        long ans = 0;
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
            {
                ans += Long.parseLong(st.nextToken());
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
