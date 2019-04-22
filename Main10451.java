import java.io.*;
import java.util.StringTokenizer;

public class Main10451
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<T;tc++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            boolean[] isVisited = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;++i)
            {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            for(int i=1;i<=n;)
            {
                if(isVisited[i])
                {
                    ++i;
                    continue;
                }
                int next = arr[i];
                while(next!=i)
                {
                    isVisited[next] = true;
                    next = arr[next];
                }
                ans++;
                isVisited[i] = true;
            }
            bw.write(ans+"\n");
        }
        bw.close();
    }

}
