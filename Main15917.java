import java.io.*;

public class Main15917
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;++i)
        {
            int a = Integer.parseInt(br.readLine());
            bw.write(Integer.bitCount(a)==1?"1\n":"0\n");
        }
        bw.close();
    }

}
