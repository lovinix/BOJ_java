import java.io.*;
import java.util.StringTokenizer;

public class Main14717
{
    static double ans,tot;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a!=b)
        {
            int c = Math.min(a,b);
            int d = Math.max(a,b);
            a = c; b = d;
        }
        else b+=10;
        for(int i=1;i<=20;++i)
        {
            for(int j=i+1;j<=20;++j)
            {
                if(i==j) continue;
                if(a==i || a==j || b==i || b==j) continue;
                if(cmp(a,b>10?b-10:b,i,j>10?j-10:j)>0) ans++;
                tot++;
            }
        }
        bw.write(String.format("%.3f", (double)Math.round(ans/tot*1000)/1000));
        bw.close();
    }
    public static int cmp(int a, int b, int c, int d)
    {
        if(a%11==b%11 && c%11==d%11)
        {
            return a%11>c%11?1:-1;
        }
        else if(a%11==b%11 && c%11!=d%11)
        {
            return 1;
        }
        else if(a%11!=b%11 && c%11==d%11)
        {
            return -1;
        }
        else
        {
            return (a+b)%10-(c+d)%10;
        }
    }

}
