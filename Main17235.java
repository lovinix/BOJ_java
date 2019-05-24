import java.io.*;
import java.util.StringTokenizer;

public class Main17235
{
    static double[][] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new double[N][2];
        double midx=0,midy=0;
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i][0] = x; arr[i][1] = y;
            midx += x/N;
            midy += y/N;
        }
        double dif = 0;
        for(double[] ar : arr)
        {
            dif = Math.max(dif, Math.abs(midx-ar[0])+ Math.abs(midy-ar[1]));
        }
        double area = 2*dif*dif;
        if((long)(area-1e-15)!=(long)(area) || (long)(area+1e-15)!=(long)area)
            bw.write(Math.round(area)+"");
        else
            bw.write(String.format("%.1f",area)+"");
        bw.close();
    }

}
