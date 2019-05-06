import java.io.*;

public class Main1075
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int r = N%F;
        if(N%100>=r)
        {
            bw.write(String.format("%02d",(N%100-r)%F));
        }
        else
        {
            bw.write(String.format("%02d",N%100+(F-r)));
        }
        bw.close();
    }

}
