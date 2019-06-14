import java.io.*;
import java.util.StringTokenizer;

public class Main6236
{
    static int N,M;
    static int[] arr;
    static long lo,hi;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
            lo = Math.max(lo,arr[i]);
        }
        hi = N * 10000;
        long ans = Long.MAX_VALUE;
        while(lo<=hi)
        {
            int cnt = 1;
            long mid = (lo+hi)/2;
            long cur = mid;
            for(int val : arr)
            {
                if(cur>=val)
                    cur-=val;
                else
                {
                    cur=mid;
                    cnt++;
                    cur-=val;
                }
            }
            if(cnt>M)
            {
                lo = mid+1;
            }
            else
            {
                hi = mid-1;
                ans = Math.min(mid,ans);
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
