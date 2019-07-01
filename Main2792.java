import java.io.*;
import java.util.StringTokenizer;

public class Main2792
{
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int l = N/M+(N%M>0?1:0);
        int r = -1;
        arr = new int[M];
        for(int i=0;i<M;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
            r = Math.max(r,arr[i]);
        }
        int min = Integer.MAX_VALUE;
        while(l<=r)
        {
            int m = (l+r)/2;
            int sum = 0;
            for(int v : arr)
            {
                sum+=v/m+(v%m>0?1:0);
            }
            if(sum<=N)
            {
                min = Math.min(min,m);
                r = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        bw.write(min+"");
        bw.close();
    }

}
