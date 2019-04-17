import java.io.*;

public class Main4999
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = br.readLine().length();
        int b = br.readLine().length();
        bw.write(a>=b?"go":"no");
        bw.close();
    }
}
