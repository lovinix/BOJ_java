import java.io.*;
import java.util.StringTokenizer;

public class Main17251_1
{
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i],max);
        }
        int lidx=-1, ridx=-1;
        for(int i=0;i<N;++i)
        {
            if(arr[i]==max)
            {
                lidx = i; break;
            }
        }
        for(int i=N-1;i>=0;--i)
        {
            if(arr[i]==max)
            {
                ridx = i; break;
            }
        }
        bw.write(lidx==(N-ridx-1)?"X":lidx<(N-ridx-1)?"R":"B");
        bw.close();
    }

}
