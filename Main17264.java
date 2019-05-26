import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main427_2
{
    static HashSet<String> hashSet = new HashSet<>();
    static int N,P,W,L,G,cur;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        for(int i=0;i<P;++i)
        {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(st.nextToken().charAt(0)=='W')
                hashSet.add(s);
        }
        for(int i=0;i<N;++i)
        {
            String s = br.readLine();
            if(hashSet.contains(s))
                cur+=W;
            else
                cur-=L;
            cur=cur<0?0:cur;
            if(cur>=G)
            {
                System.out.print("I AM NOT IRONMAN!!");
                return;
            }
        }
        System.out.print("I AM IRONMAN!!");
        bw.close();
    }

}
