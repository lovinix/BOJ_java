import java.io.*;

public class Main4597
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            String s = br.readLine();
            if(s.equals("#")) break;
            int flag = 0;
            for(int i=0;i<s.length()-1;++i)
            {
                flag+=(s.charAt(i)-'0');
            }
            int last = s.charAt(s.length()-1)=='e'?0:1;
            bw.write(s.substring(0,s.length()-1)+((flag%2)^last)+"\n");
        }
        bw.close();
    }

}
