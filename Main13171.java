import java.io.*;

public class Main13171
{
    static final long d = 1000000007;
    static long A,X;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        A = Long.parseLong(br.readLine());
        X = Long.parseLong(br.readLine());
        bw.write(recv(X)+"");
        bw.close();

    }

    public static long recv(long x)
    {
        if(x==1) return A%d;
        else
        {
            if(x%2==0)
            {
                long ret = recv(x/2);
                return (ret*ret)%d;
            }
            else
            {
                long ret = recv(x/2);
                return (((ret*ret)%d)*recv(1))%d;
            }
        }
    }
}
