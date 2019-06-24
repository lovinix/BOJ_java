import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1327
{
    static int N,K,input;
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[] isvisited = new boolean[100000000];
    static int ans,out;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            input*=10;
            input+=Integer.parseInt(st.nextToken());
            ans*=10;
            ans+=i+1;
        }
        q.offer(input);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int z=0;z<size;++z)
            {
                int cur = q.poll();
                if (cur == ans)
                {
                    System.out.print(out);
                    return;
                }
                for (int i = 0; i <= N - K; ++i)
                {
                    int l = cur;
                    int m = (cur % (int) Math.pow(10, N - i));
                    int r = m % (int) Math.pow(10, N - i - K);
                    l -= m;
                    m /= (int) Math.pow(10, N - i - K);
                    int next = l + rev(m) * (int) Math.pow(10, N - i - K) + r;
                    if (isvisited[next]) continue;
                    isvisited[next] = true;
                    q.offer(next);
                }
            }
            ++out;
        }
        bw.write("-1");
        bw.close();
    }
    public static int rev(int m)
    {
        int ret = 0;
        for(int i=0;i<K;++i)
        {
            ret = ret*10 + m%10;
            m/=10;
        }
        return ret;
    }
}
