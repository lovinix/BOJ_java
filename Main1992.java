import java.io.*;
import java.util.StringTokenizer;

public class Main1992
{
    static int[][] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;++i)
        {
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<N;++j)
            {
                arr[i][j] = (c[j]-'0');
            }
        }
        bw.write(recv(0,0,N-1,N-1));
        bw.close();

    }

    public static String recv(int n1, int m1, int n2,int m2)
    {
        if(n1>n2 || m1>m2) return "";
        int cur = chk(n1,m1,n2,m2);
        if( cur == 1 ) return "1";
        else if (cur == 0) return "0";
        String s = "(";
        s+=recv(n1,m1,n1+(n2-n1)/2,m1+(m2-m1)/2);
        s+=recv(n1,m1+(m2-m1)/2+1,n1+(n2-n1)/2,m2);
        s+=recv(n1+(n2-n1)/2+1,m1,n2,m1+(m2-m1)/2);
        s+=recv(n1+(n2-n1)/2+1,m1+(m2-m1)/2+1,n2,m2);
        s+=")";
        return s;
    }

    public static int chk(int n1, int m1, int n2, int m2)
    {
        int sum = 0;
        for(int i=n1;i<=n2;++i)
        {
            for(int j=m1;j<=m2;++j)
            {
                sum+=arr[i][j];
            }
        }
        if(sum == 0) return 0;
        else if( sum == (n2-n1+1)*(m2-m1+1)) return 1;
        else return -1;
    }
}
