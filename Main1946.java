import java.io.*;
import java.util.StringTokenizer;

public class Main1946
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++)
        {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            for(int i=1;i<=N;++i)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }
            int cur = arr[1];
            int sum = 1;
            for(int i=2;i<=N;++i)
            {
                if(arr[i]<cur)
                {
                    cur = arr[i];
                    sum++;
                }
            }
            bw.write(sum+"\n");
        }
        bw.close();
    }
}
