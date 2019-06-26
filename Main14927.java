import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main14927
{
    static int ans = Integer.MAX_VALUE,N;
    static int[][] arr, tmp;
    static BitSet bitSet = new BitSet();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        tmp = new int[N][N];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recv(0);
        bw.write(ans==Integer.MAX_VALUE?"-1":(ans+""));
        bw.close();
    }
    public static void recv(int idx)
    {
        if(idx<N)
        {
            bitSet.set(idx);
            recv(idx+1);
            bitSet.clear(idx);
            recv(idx+1);
            return;
        }
        int cnt = 0;
        for(int i=0;i<N;++i)
            System.arraycopy(arr[i],0,tmp[i],0,N);
        for(int i=0;i<N;++i)
        {
            if(bitSet.get(i))
            {
                pushb(0,i);
                ++cnt;
            }
        }
        for(int i=1;i<N;++i)
        {
            for(int j=0;j<N;++j)
            {
                if(tmp[i-1][j]==1)
                {
                    pushb(i,j);
                    ++cnt;
                }
            }
        }
        for(int i=0;i<N;++i)
        {
            if(tmp[N-1][i]==1)
                return;
        }
        ans = Math.min(ans,cnt);
    }
    public static void pushb(int n,int m)
    {
        tmp[n][m]^=1;
        if(n>0)
            tmp[n-1][m]^=1;
        if(m>0)
            tmp[n][m-1]^=1;
        if(n<N-1)
            tmp[n+1][m]^=1;
        if(m<N-1)
            tmp[n][m+1]^=1;
    }
}
