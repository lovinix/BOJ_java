import java.io.*;
import java.util.StringTokenizer;

public class Main1292
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[1001];
        int[] sum = new int[1001];
        int count = 0;
        int target = 1;
        for(int i=1;i<=1000;++i)
        {
            if(count==target)
            {
                target++;
                count=0;
            }
            arr[i] = target;
            count++;
            sum[i] = sum[i-1]+arr[i];
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        bw.write((sum[t]-sum[s-1])+"");
        bw.close();
    }

}
