import java.io.*;

public class Main6359
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T =Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++)
        {
            boolean[] arr = new boolean[Integer.parseInt(br.readLine())+1];
            for(int i=1,len=arr.length;i<len;++i)
            {
                for(int j=i;j<len;j+=i)
                {
                    arr[j]=!arr[j];
                }
            }
            int sum=0;
            for(int i=1,len=arr.length;i<len;++i)
            {
                sum+=arr[i]?1:0;
            }
            bw.write(sum+"\n");
        }
        bw.close();
    }
}
