import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14467
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        int sum = 0;
        for(int i=0;i<n;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(arr[a]==-1||arr[a]==b)
            {
                arr[a]=b;
                continue;
            }
            arr[a]=b;
            sum++;
        }
        bw.write(sum+"");
        bw.close();
    }
}
