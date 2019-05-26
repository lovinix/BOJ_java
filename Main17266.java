import java.io.*;
import java.util.StringTokenizer;

public class Main427_4
{
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for(int i=0;i<M-1;++i)
        {
            max = Math.max(max,(arr[i+1]-arr[i])/2+(arr[i+1]-arr[i])%2);
        }
        max = Math.max(max, arr[0]);
        max = Math.max(max, N-arr[arr.length-1]);
        bw.write(max+"");
        bw.close();
    }

}
