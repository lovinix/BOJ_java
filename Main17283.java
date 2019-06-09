import java.io.*;

public class Main434_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double N = Double.parseDouble(br.readLine());
        double r = Double.parseDouble(br.readLine())/100;
        double ans = 0.0;
        int a = 1;
        while(N>5)
        {
            double tmp=(a*=2)*(N=(int)(N*r));
            ans+=N>5?tmp:0;
        }
        bw.write((int)ans+"");
        bw.close();
    }

}
