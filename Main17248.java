import java.io.*;
import java.util.StringTokenizer;

public class Main17248
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;++tc)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int ans = 0,t=1;
            while(x<y)
            {
                x+=z*t++;
                ans++;
            }
            bw.write(ans+"\n");
        }
        bw.close();
    }

}
