import java.io.*;
import java.util.StringTokenizer;

public class Main424_2
{
    static double[][] arr;
    static double[] pb = new double[4];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;++i) pb[i]=Double.parseDouble(st.nextToken());
        arr = new double[N+1][2];
        arr[0][M] = 1;
        arr[0][M^1] = 0;
        for(int i=1;i<=N;++i)
        {
            arr[i][0] = arr[i-1][0]*pb[0] + arr[i-1][1]*pb[2];
            arr[i][1] = arr[i-1][0]*pb[1] + arr[i-1][1]*pb[3];
        }
        bw.write(Math.round(arr[N][0]*1000)+"\n"+ Math.round(arr[N][1]*1000));
        bw.close();
    }

}
