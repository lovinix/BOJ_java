import java.io.*;
import java.util.StringTokenizer;

public class Main1246
{
    static long[] arr;
    static int n,m;
    static long sum,ans1,ans2,min=Long.MAX_VALUE,max=-1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[m];
        for(int i=0;i<m;++i)
        {
            arr[i] = Long.parseLong(br.readLine());
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        long l = min,r=max;
        while(l<=r)
        {
            long mid = (l+r)/2;
            sum = 0;
            long num = 0;
            for(int i=0;i<m;++i)
            {
                if (arr[i] >= mid && num < n)
                {
                    sum+=mid;
                    ++num;
                }
                if(num==n) break;
            }
            if(sum>=ans2)
            {
                ans1 = mid;
                ans2 = sum;
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        bw.write(ans1+" "+ans2);
        bw.close();
    }

}
