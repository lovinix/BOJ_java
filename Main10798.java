import java.io.*;

public class Main10798
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] ar = new char[5][];
        for(int i=0;i<5;++i)
        {
            ar[i] = br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<15;++j)
        {
            for(int i=0;i<5;++i)
            {
                if(j>=ar[i].length) continue;
                sb.append(ar[i][j]);
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

}
