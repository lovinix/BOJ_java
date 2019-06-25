import java.io.*;
import java.util.Arrays;

public class Main2751 {
    public static void main(String[]args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int hello = Integer.parseInt(br.readLine());
        Integer [] arr = new Integer[hello];
        for(int i = 0; i<hello;i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = 0; i<arr.length;i++)
        {
            bw.write(arr[i]+"\n");
        }
        bw.close();
    }

}
