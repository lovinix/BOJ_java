import java.io.*;

public class Main2443
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            for(int j=i;j>0;--j)
            {
                bw.write(" ");
            }
            for(int j=0;j<2*N-2*i-1;++j)
            {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
