import java.io.*;
import java.util.StringTokenizer;

public class Main17203
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] difsum = new int[N];
        int[] arr = new int[N];
        difsum[0] = 0;
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            difsum[i] = Math.abs(arr[i-1]-arr[i])+difsum[i-1];
        }
        for(int q=0;q<Q;++q)
        {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if(j<=i)
            {
                bw.write("0\n");
                continue;
            }
            bw.write(difsum[j-1]-difsum[i-1]+"\n");
        }
        bw.close();
    }

}
