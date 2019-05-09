import java.io.*;

public class Main5597
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[31];
        String s;
        while((s=br.readLine())!=null)
        {
            arr[Integer.parseInt(s)]++;
        }
        for(int i=1;i<=30;++i)
        {
            if(arr[i]==0)
                bw.write(i+"\n");
        }
        bw.close();
    }

}
