import java.io.*;

public class Main15894
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.parseLong(br.readLine())*4+"");
        bw.close();
    }
}
