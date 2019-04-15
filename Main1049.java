import java.io.*;
import java.util.StringTokenizer;

public class Main1049
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min6 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        while(M-->0)
        {
            st = new StringTokenizer(br.readLine());
            min6 = Math.min(min6,Integer.parseInt(st.nextToken()));
            min1 = Math.min(min1, Integer.parseInt(st.nextToken()));
        }
        if(min6>(6*min1))
        {
            bw.write((N*min1)+"");
        }
        else
        {
            bw.write(((N/6)*min6+(min6<((N%6)*min1)?min6:(N%6)*min1))+"");
        }
        bw.close();
    }
}
