import java.io.*;
import java.util.StringTokenizer;

public class Main14646
{
    static boolean[] flag;
    static int max = 0;
    static int cur = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        flag = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
        {
            int a = Integer.parseInt(st.nextToken());
            if(flag[a])
            {
                flag[a] = false;
                cur--;
            }
            else
            {
                flag[a] = true;
                cur++;
                max = Math.max(max,cur);
            }
        }
        bw.write(max+"");
        bw.close();
    }

}
