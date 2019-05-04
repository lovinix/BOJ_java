import java.io.*;
import java.util.StringTokenizer;

public class Main408_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int sum = N;
        while(N!=0)
        {
            sum+=(N/=M);
        }
        bw.write(sum+"");
        bw.close();
    }

}
