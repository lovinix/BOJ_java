import java.io.*;
import java.util.StringTokenizer;

public class Main408_5
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        double c = Integer.parseInt(st.nextToken());
        double r = a/2;
        double theta1 = Math.acos((2*r*r-b*b)/(2*r*r));
        double theta2 = Math.acos((2*r*r-c*c)/(2*r*r));
        if(theta1+theta2>= Math.PI)
        {
            System.out.print(-1); return;
        }
        double theta3 = Math.PI-theta1-theta2;
        double ans = Math.sqrt(2*r*r-2*r*r* Math.cos(theta3));
        bw.write(Math.round(ans)+"");
        bw.close();
    }

}
