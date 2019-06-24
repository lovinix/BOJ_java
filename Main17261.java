import java.io.*;
import java.util.StringTokenizer;

public class Main17261
{
    static int[] tree;
    static boolean[] leaf;
    static int N;
    static long ans[], v, cur;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        v = Integer.highestOneBit(N);
        tree = new int[2 * N + 10];
        leaf = new boolean[N + 1];
        ans = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i)
            tree[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; ++i)
        {
            if (tree[2 * i] + tree[2 * i + 1] == 0) leaf[i] = true;
        }
        while (tree[1] > 0)
        {
            int min = Integer.MAX_VALUE;
            int num = 0;
            for (int i = 1; i <= N; ++i)
            {
                if (leaf[i])
                {
                    min = Math.min(min, tree[i]);
                    ++num;
                }
            }
            cur+=min*num/v+(min*num%v==0?0:1);
            recv(1,min*num+(min*num%v==0?0:v-(min*num%v)));
        }
        for(int i=1;i<=N;++i)
            bw.write(ans[i]+" ");
        bw.close();
    }
    public static long recv(int idx, long q)
    {
        if(tree[idx]<=0) return q;
        long r = 0;
        if(q>1)
        {
            if(tree[idx*2]==0)
                r += recv(idx*2+1,q);
            else if(tree[idx*2+1]==0)
                r += recv(idx*2,q);
            else
                r+= recv(idx*2,q/2)+recv(idx*2+1,q/2);
        }
        else r = q;
        long m = Math.min(tree[idx],r);
        tree[idx]-=m;
        r-=m;
        if(tree[idx]!=0 && tree[idx*2]==0 && tree[idx*2+1]==0)
            leaf[idx] = true;
        if(tree[idx]<=0)
        {
            leaf[idx] = false;
            ans[idx] = cur;
        }
        return r;

    }
}
