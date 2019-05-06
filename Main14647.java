import java.io.*;
import java.util.StringTokenizer;

public class Main14647
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int num = 0;
        int max = 0;
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j)
            {
                int n = 0;
                char[] tmp = st.nextToken().toCharArray();
                for(char c: tmp)
                {
                    if(c=='9') n++;
                }
                arr[i][j] = n;
                num+=n;
            }
        }
        for(int i=0;i<N;++i)
        {
            int sum = 0;
            for(int j=0;j<M;++j)
            {
                sum+=arr[i][j];
            }
            max = Math.max(max,sum);
        }
        for(int j=0;j<M;++j)
        {
            int sum = 0;
            for(int i=0;i<N;++i)
            {
                sum+=arr[i][j];
            }
            max = Math.max(max,sum);
        }
        bw.write((num-max)+"");
        bw.close();
    }

}
