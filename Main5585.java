import java.io.*;

public class Main5585
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1000 - Integer.parseInt(br.readLine());
        int a = n%500;
        int b = a%100;
        int c = b%50;
        int d = c%10;
        int e = d%5;
        bw.write( (n/500+a/100+b/50+c/10+d/5+e)+"");
        bw.close();
    }

}
