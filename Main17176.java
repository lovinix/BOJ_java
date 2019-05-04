import java.io.*;
import java.util.StringTokenizer;

public class Main408_4
{
    static int[] cnt1 = new int[53];
    static int[] cnt2 = new int[53];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            int cur = Integer.parseInt(st.nextToken());
            cnt1[cur]++;
        }
        char[] tmp = br.readLine().toCharArray();
        for(char c : tmp)
        {
            if(c==' ') cnt2[0]++;
            else if(c<='Z') cnt2[c-'A'+1]++;
            else cnt2[c-'a'+27]++;
        }
        for(int i=0;i<53;++i)
        {
            if(cnt1[i]!=cnt2[i])
            {
                System.out.print("n"); return;
            }
        }
        System.out.print("y");
    }

}
