import java.io.*;

public class Main2754
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        if(s.charAt(0)=='F')
            System.out.print(0.0);
        else
        {
            System.out.print((4.0+'A'-s.charAt(0)+(s.charAt(1)=='+'?0.3:s.charAt(1)=='-'?-0.3:0.0)));
        }
        bw.close();
    }

}
