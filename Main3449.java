import java.io.*;

public class Main3449
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;++tc)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            int d = 0;
            for(int i=0;i<s1.length();++i)
            {
                d+=s1.charAt(i)==s2.charAt(i)?0:1;
            }
            bw.write("Hamming distance is "+d+".\n");
        }
        bw.close();
    }

}
