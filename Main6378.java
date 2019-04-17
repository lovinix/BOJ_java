import java.io.*;

public class Main6378
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n;
        while(!(n=br.readLine()).equals("0"))
        {
            int next = 0;
            char[] arr = n.toCharArray();
            do
            {
                for (char c : arr)
                {
                    next += c - '0';
                }
                if (next >= 10)
                {
                    arr = Integer.toString(next).toCharArray();
                    next = 0;
                }
                else
                {
                    bw.write(next + "\n");
                    break;
                }
            }while(true);
        }
        bw.close();
    }
}
