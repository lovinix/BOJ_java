import java.io.*;
import java.util.StringTokenizer;

public class Main434_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = {0,500,800,1000};
        int ans = 5000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements())
            ans-=arr[Integer.parseInt(st.nextToken())];
        bw.write(ans+"");
        bw.close();
    }

}
