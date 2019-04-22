import java.io.*;

public class Main2444
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;++i)
        {
            for(int j=N;j>i;--j)
            {
                bw.write(" ");
            }
            for(int j=0;j<2*i-1;++j)
            {
                bw.write("*");
            }
            bw.write("\n");
        }
        for(int i=N-1;i>0;--i)
        {
            for(int j=0;j<N-i;++j)
            {
                bw.write(" ");
            }
            for(int j=0;j<2*i-1;++j)
            {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
