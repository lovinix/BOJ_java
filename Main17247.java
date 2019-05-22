import java.io.*;
import java.util.StringTokenizer;

public class Main17247
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[4];
        int idx = 0;
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j)
            {
                if(Integer.parseInt(st.nextToken())==1)
                {
                    arr[idx++]=i;
                    arr[idx++]=j;
                }
            }
        }
        bw.write((Math.abs(arr[0]-arr[2])+ Math.abs(arr[1]-arr[3]))+"");
        bw.close();
    }

}
