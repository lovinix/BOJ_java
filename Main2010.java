import java.io.*;

public class Main2010
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0;i<N;++i)
        {
            ans+=Integer.parseInt(br.readLine());
        }
        bw.write((ans-N+1)+"");
        bw.close();
    }

}
