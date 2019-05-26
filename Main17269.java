import java.io.*;
import java.util.StringTokenizer;

public class Main427_7
{
    static int[] alpha = {3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};
    static int[] ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ans = new int[N+M];
        st = new StringTokenizer(br.readLine());
        String[] s = new String[2];
        s[0] = st.nextToken();
        s[1] = st.nextToken();
        int i,j,cur=0;
        for(i=0,j=0;i<N&&j<M;cur++)
        {
            ans[cur] = cur%2==0?alpha[s[0].charAt(i++)-'A']:alpha[s[1].charAt(j++)-'A'];
        }
        while(i<N)
        {
            ans[cur++]=alpha[s[0].charAt(i++)-'A'];
        }
        while(j<M)
        {
            ans[cur++]=alpha[s[1].charAt(j++)-'A'];
        }
        int size = ans.length;
        while(size>2)
        {
            for(i=0;i<size-1;++i)
            {
                ans[i] = (ans[i]+ans[i+1])%10;
            }
            --size;
        }
        bw.write((ans[0]==0?"":ans[0])+""+ans[1]+"%");
        bw.close();
    }

}
