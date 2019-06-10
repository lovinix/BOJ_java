import java.io.*;

public class Main434_9
{
    static int[] arr = new int[21];
    static int sum = 1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr[1] = 1;
        for(int i=2;i<=n;++i)
        {
            if(i%2==1)
            {
                arr[i] = sum;
                sum+=arr[i];
            }
            else
            {
                arr[i] = sum;
                sum+=arr[i];
                if(i>=4) sum-=arr[i-3];
                if(i>=5) sum-=arr[i-4];
            }
        }
        bw.write(sum+"");
        bw.close();
    }

}
