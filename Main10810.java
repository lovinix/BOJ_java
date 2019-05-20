import java.io.*;
import java.util.StringTokenizer;

public class Main10810
{
    static int[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int tc=0;tc<m;++tc)
        {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(;i<=j;i++)
            {
                arr[i] = k;
            }
        }
        for(int i=1;i<=n;++i)
            bw.write(arr[i]+" ");
        bw.close();
    }

}
