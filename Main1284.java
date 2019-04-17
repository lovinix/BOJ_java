import java.io.*;

public class Main1284
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(!(s=br.readLine()).equals("0"))
        {
            int sum = 1;
            char[] arr = s.toCharArray();
            for(char c : arr)
            {
                if(c=='1') sum+=2;
                else if(c=='0') sum+=4;
                else sum+=3;
                ++sum;
            }
            bw.write(sum+"\n");
        }
        bw.close();
    }
}
