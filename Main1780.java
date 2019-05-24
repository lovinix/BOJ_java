import java.io.*;
import java.util.StringTokenizer;

public class Main1780
{
    static int[][] arr;
    static int N;
    static int ans[];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = new int[3];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recv(0,0,N,N);
        bw.write(ans[0]+"\n"+ans[1]+"\n"+ans[2]);
        bw.close();
    }
    public static void recv(int n1,int m1, int n2,int m2)
    {
        if(n1==n2 && m1==m2)
        {
            ans[arr[n1][m1]+1]++; return;
        }
        int first = arr[n1][m1];
        boolean flag = true;
        loop : for(int i=n1;i<n2;++i)
        {
            for(int j=m1;j<m2;++j)
            {
                if(arr[i][j] != first)
                {
                    flag = false;
                    break loop;
                }
            }
        }
        if(flag) ans[first+1]++;
        else
        {
            for(int i=0;i<3;++i)
            {
                for(int j=0;j<3;++j)
                {
                    recv(((3-i)*n1+i*n2)/3,((3-j)*m1+j*m2)/3,((2-i)*n1+(1+i)*n2)/3,((2-j)*m1+(1+j)*m2)/3);
                }
            }
        }
    }
}
