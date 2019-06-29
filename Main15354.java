import java.io.*;

public class Main15354
{
    static int N, ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        for(int i=0;i<N;++i)
        {
            arr[i] = br.readLine().charAt(0);
        }
        char c = arr[0];
        ans++;
        for(int i=1;i<N;++i)
        {
            if(c!=arr[i])
            {
                c = arr[i];
                ans++;
            }
        }
        bw.write((ans+1)+"");
        bw.close();
    }

}
