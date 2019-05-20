import java.io.*;

public class Main10570
{
    static int[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;++tc)
        {
            int v = Integer.parseInt(br.readLine());
            arr = new int[1001];
            for(int i=0;i<v;++i)
            {
                arr[Integer.parseInt(br.readLine())]++;
            }
            int val = Integer.MAX_VALUE; int count = -1;
            for(int i=1000;i>=0;--i)
            {
                if(count<=arr[i])
                {
                    count = arr[i];
                    val = i;
                }
            }
            bw.write(val+"\n");
        }
        bw.close();
    }

}
