import java.io.*;
import java.util.StringTokenizer;

public class Main1680
{
    static int[] xi,wi;
    static long curd,curw;
    static int W,N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;++tc)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            xi = new int[N]; wi = new int[N];
            curd=0;curw=0;
            for(int i=0;i<N;++i)
            {
                st = new StringTokenizer(br.readLine());
                xi[i] = Integer.parseInt(st.nextToken());
                wi[i] = Integer.parseInt(st.nextToken());
                curd+=i==0?xi[i]:xi[i]-xi[i-1];
                if(curw+wi[i]>W)
                {
                    curd+=2*xi[i];
                    curw = 0;
                }
                curw+=wi[i];
                if(curw==W && i!=N-1)
                {
                    curd+=2*xi[i];
                    curw=0;
                }
                if(i==N-1)
                {
                    curd+=xi[i];
                }
            }
            bw.write(curd+"\n");
        }
        bw.close();
    }

}