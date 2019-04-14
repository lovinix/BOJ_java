import java.io.*;
import java.util.Arrays;

public class Main4948
{
    static int[] prime;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        prime = new int[2*123456+1];
        Arrays.fill(prime,-1);
        prime[1] = 0;
        prime[2] = 1;
        int n;
        while((n=Integer.parseInt(br.readLine()))!=0)
        {
            int sum = 0;
            for(int i=n+1;i<=2*n;++i)
            {
                if(isPrime(i)) sum++;
            }
            bw.write(sum+"\n");
        }
        bw.close();
    }
    public static boolean isPrime(int n)
    {
        if(prime[n]!=-1)
        {
            return prime[n]==0?false:true;
        }
        for(int i=2,end = (int)Math.sqrt(n)+1;i<=end;++i)
        {
            if(isPrime(i)==false) continue;
            if(n%i==0)
            {
                prime[n] = 0;
                return false;
            }
        }
        prime[n] = 1;
        return true;
    }
}
