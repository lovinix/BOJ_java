import java.io.*;

public class Main5988
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;++i)
        {
            String s = br.readLine();
            int a = s.charAt(s.length()-1)-'0';
            bw.write(a%2==0?"even\n":"odd\n");
        }
        bw.close();
    }

}
