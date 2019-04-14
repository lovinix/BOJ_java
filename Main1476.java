import java.io.*;
import java.util.StringTokenizer;

public class Main1476
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken())%15;
        int S = Integer.parseInt(st.nextToken())%28;
        int M = Integer.parseInt(st.nextToken())%19;
        int lcm = 15*28/gcd(15,28);
        lcm = lcm*19/gcd(lcm,19);
        for(int i=1;i<=lcm;++i)
        {
            if(i%15==E && i%28==S && i%19==M)
            {
                bw.write(i+"");
            }
        }
        bw.close();
    }

    public static int gcd(int n,int m)
    {
        int a = Math.max(n,m);
        int b = Math.min(n,m);
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}
