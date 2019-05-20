import java.io.*;

public class Main2703
{
    static char[] crypt;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;++tc)
        {
            char[] str = br.readLine().toCharArray();
            crypt = br.readLine().toCharArray();
            for(char c : str)
            {
                bw.write(c==' '?c:crypt[c-'A']);
            }
            bw.write("\n");
        }
        bw.close();
    }

}
