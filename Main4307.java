import java.io.*;
import java.util.StringTokenizer;

public class Main4307
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; ++i)
            {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int min = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int n : arr)
            {
                min = Math.max(min, Math.min(n, L - n));
                max = Math.max(max, Math.max(n, L - n));
            }
            bw.write(min+" "+max+"\n");
        }
        bw.close();
    }
}
