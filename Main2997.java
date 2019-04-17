import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2997
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i=0;i<3;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int dif1 = arr[1]-arr[0];
        int dif2 = arr[2]-arr[1];
        if(dif1==dif2)
        {
            bw.write((arr[2]+dif1)+"");
        }
        else
        {
            if(dif1>dif2)
            {
                bw.write((arr[0]+dif1/2)+"");
            }
            else
            {
                bw.write((arr[1]+dif2/2)+"");
            }
        }
        bw.close();
    }
}
