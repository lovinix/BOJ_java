import java.io.*;
import java.util.StringTokenizer;

public class Main17179
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int sum = 0, min = 0;
        int[] ar = new int[M];
        int[] num = new int[N];
        for(int i=0;i<M;++i)
        {
            ar[i] = i==0?Integer.parseInt(br.readLine()):Integer.parseInt(br.readLine())-ar[i-1];
            sum+=ar[i];
            min = Math.max(ar[i],min);
        }
        for(int i=0;i<N;++i)
        {
            num[i] = Integer.parseInt(br.readLine());
        }
        for(int q : num)
        {
            int lo = min;
            int hi = sum;
            int ans = Integer.MAX_VALUE;
            while(lo<=hi)
            {
                int mid = (lo+hi)/2;
                int presum = 0;
                int qi = 0;
                for(int i=0;i<ar.length;++i)
                {
                    if(presum+ar[i]>mid)
                    {
                        presum = 0;
                        qi++;
                    }
                    else
                    {
                        presum+=ar[i];
                    }
                }
                if(qi>q)
                {
                    lo = mid + 1;
                }
                else
                {
                    hi = mid -1;
                    ans = Math.min(mid,ans);
                }
            }
            bw.write(ans+"\n");
        }
        bw.close();
    }

}
