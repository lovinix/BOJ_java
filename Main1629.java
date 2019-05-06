import java.io.*;
import java.util.StringTokenizer;

public class Main1629
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] ar = new long[32];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        ar[1] = A;
        for(int i=2;i<32;++i)
        {
            ar[i] = (ar[i-1]*ar[i-1])%C;
        }
        int i=1;
        long ans = 1;
        while(B>0)
        {
            if((B&1)==1)
            {
                ans=(ans*ar[i])%C;
            }
            i++;
            B=B>>1;
        }
        bw.write(ans+"");
        bw.close();
    }
}
