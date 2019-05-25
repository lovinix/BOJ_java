import java.io.*;
import java.util.StringTokenizer;

public class Main17245
{
    static int[] cntarr = new int[10000001];
    static int N, cnt;
    static long total,sum;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j)
            {
                int cur = Integer.parseInt(st.nextToken());
                cntarr[cur]++;
                total += cur;
                cnt+=cur>0?1:0;
            }
        }
        if(total == 0 ) {System.out.print(0); return;}
        for(int t=1;t<=10000000;++t)
        {
            sum+=cnt;
            cnt-=cntarr[t];
            if(sum*2>=total)
            {
                bw.write(t+"");
                break;
            }
        }
        bw.close();
    }

}
