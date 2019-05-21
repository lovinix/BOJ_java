import java.io.*;

public class Main17253
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        if(n==0)
        {
            System.out.print("NO"); return;
        }
        String s = Long.toString(n,3);
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='2')
            {
                System.out.print("NO");
                return;
            }
        }
        bw.write("YES");
        bw.close();
    }

}
