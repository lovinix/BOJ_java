import java.io.*;
import java.util.StringTokenizer;

public class Main4072
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(!(s = br.readLine()).equals("#"))
        {
            StringTokenizer st = new StringTokenizer(s);
            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens())
            {
                sb.append(new StringBuilder(st.nextToken()).reverse()+" ");
            }
            bw.write(sb.toString().trim()+"\n");
        }
        bw.close();
    }
}
