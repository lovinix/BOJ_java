import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17216
{
    static int[] arr;
    static int[] dpsum;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dpsum = new int[N];
        Arrays.fill(dpsum,-1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for(int i=0;i<N;++i)
            recv(i);
        for(int i=0;i<N;++i)
            max = Math.max(max,dpsum[i]);
        bw.write(max+"");
        bw.close();
    }
    public static int recv(int idx)
    {
        if(idx>=N) return 0;
        if(dpsum[idx]!=-1) return dpsum[idx];
        int ret = arr[idx];
        for(int i=1;;++i)
        {
            if(idx+i>=N) break;
            if(arr[idx+i]<arr[idx])
            {
                ret = Math.max(ret, arr[idx]+recv(idx+i));
            }
        }
        return dpsum[idx] = ret;
    }
}
