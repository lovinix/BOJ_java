import java.io.*;
import java.util.StringTokenizer;

public class Main408_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;++i)
        {
            int cur = Integer.parseInt(st.nextToken());
            int next = cur;
            while(next<=N)
            {
                arr[next]=true;
                next+=cur;
            }
        }
        int sum = 0;
        for(int i=0;i<=N;++i)
        {
            if(arr[i])sum+=i;
        }
        bw.write(sum+"");
        bw.close();

    }

}
