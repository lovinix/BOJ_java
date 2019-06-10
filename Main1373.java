import java.io.*;

public class Main1373
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        while(sb.length()%3!=0)
            sb.insert(0,'0');
        for(int i=0;i<sb.length()-2;i+=3)
        {
            bw.write(Integer.toString(Integer.parseInt(sb.substring(i,i+3),2),8));
        }
        bw.close();
    }

}
