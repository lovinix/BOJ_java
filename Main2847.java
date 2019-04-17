import java.io.*;

public class Main2847
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;++i)
        {
            arr[i]= Integer.parseInt(br.readLine());
        }
        int cur = arr[n-1];
        int sum = 0;
        for(int i=arr.length-2;i>=0;--i)
        {
            if(arr[i]>=cur)
            {
                sum += arr[i] - cur + 1;
                arr[i] = cur - 1;
            }
            cur = arr[i];
        }
        bw.write(sum+"");
        bw.close();
    }
}
