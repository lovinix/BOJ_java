import java.io.*;
import java.util.StringTokenizer;

public class Main1735
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] arr = new long[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken()); arr[1] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr[2] = Integer.parseInt(st.nextToken()); arr[3] = Integer.parseInt(st.nextToken());
        long gcd = gcd(arr[0],arr[1]);
        arr[0]/=gcd; arr[1]/=gcd;
        gcd = gcd(arr[2],arr[3]);
        arr[2]/=gcd; arr[3]/=gcd;
        gcd = gcd(arr[1],arr[3]);
        long lcm = arr[1]*arr[3]/gcd;
        arr[0] *= arr[3]/gcd;
        arr[2] *= arr[1]/gcd;
        arr[1] = lcm; arr[3] = lcm;
        long ans = arr[0]+arr[2];
        gcd = gcd(ans,lcm);
        bw.write(ans/gcd+" "+lcm/gcd);
        bw.close();
    }
    public static long gcd(long a, long b)
    {
        long max = Math.max(a,b);
        long min = Math.min(a,b);
        if(max%min==0) return min;
        return gcd(max%min,min);
    }
}
