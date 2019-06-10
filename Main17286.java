import java.io.*;
import java.util.StringTokenizer;

public class Main434_4
{
    static double ans = Double.MAX_VALUE;
    static Point[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new Point[4];
        for(int i=0;i<4;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr[i] = new Point(n,m);
        }
        recv(1);
        bw.write((int)ans+"");
        bw.close();
    }
    public static void recv(int idx)
    {
        if(idx==4)
        {
            double val = 0;
            for(int i=0;i<3;++i)
            {
                val+=arr[i].getdist(arr[i+1]);
            }
            ans = Math.min(ans,val);
        }
        else
        {
            for(int i=idx;i<4;++i)
            {
                Point tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                recv(idx+1);
                tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
            }
        }
    }
}
class Point
{
    int n,m;
    Point(int n, int m)
    {
        this.n=n;this.m=m;
    }
    public double getdist(Point point)
    {
        return Math.sqrt((n - point.n)*(n-point.n)+(m-point.m)*(m-point.m));
    }
}