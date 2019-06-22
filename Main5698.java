import java.io.*;
import java.util.StringTokenizer;

public class Main5698
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        test : while(!(s=br.readLine()).equals("*"))
        {
            StringTokenizer st = new StringTokenizer(s);
            char c = Character.toLowerCase(st.nextToken().charAt(0));
            while(st.hasMoreElements())
            {
                char cur = st.nextToken().charAt(0);
                if(c!=Character.toLowerCase(cur))
                {
                    bw.write("N\n");
                    continue test;
                }
            }
            bw.write("Y\n");
        }
        bw.close();
    }

}
