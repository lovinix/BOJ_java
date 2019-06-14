import java.io.*;
import java.util.Arrays;

public class Main6500_2
{
    static boolean[] isvisited = new boolean[10000];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int val;
        while((val = Integer.parseInt(br.readLine()))!=0)
        {
            Arrays.fill(isvisited,false);
            int ans = 0;
            while(!isvisited[val])
            {
                isvisited[val]=true;
                ++ans;
                val = (val*val)%1000000/100;
            }
            bw.write(ans+"\n");
        }
        bw.close();
    }

}
