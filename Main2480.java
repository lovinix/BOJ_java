import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2480
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i=0;i<3;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(arr[0]==arr[2])
        {
            bw.write((arr[0]*1000+10000)+"");
        }
        else if(arr[1]==arr[0] || arr[1]==arr[2])
        {
            bw.write((arr[1]*100+1000)+"");
        }
        else
        {
            bw.write(100*arr[2]+"");
        }
        bw.close();
    }
}
