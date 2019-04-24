import java.io.*;
import java.util.StringTokenizer;

public class Main1182
{
    static int[] arr;
    static int isVisited=0;
    static int N,K,ans=0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recv(0);
        bw.write(ans+"");
        bw.close();

    }
    public static void recv(int idx)
    {
        if(idx<N)
        {
            isVisited = (isVisited<<1) +1;
            recv(idx+1);
            isVisited = (isVisited>>1)<<1;
            recv(idx+1);
            isVisited = isVisited>>1;
        }
        else if(idx==N)
        {
            int sum = 0;
            if(isVisited==0)
            {
                return;
            }
            for(int i=0;i<N;++i)
            {
                if(((isVisited>>(N-1-i))&1)==1)
                {
                    sum += arr[i];
                }
            }
            if(sum==K) ans++;
        }
    }
}
