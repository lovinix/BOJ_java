import java.io.*;
import java.util.StringTokenizer;

public class Main15902
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr1 = new boolean[n+1];
        boolean[] arr2 = new boolean[n+1];
        int n1 = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;)
        {
            int next = Integer.parseInt(st.nextToken());
            arr1[i+=next] = true;
        }
        int n2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;)
        {
            int next = Integer.parseInt(st.nextToken());
            arr2[i+=next] = true;
        }
        int ans = 0;
        for(int i=1;i<=n;++i)
        {
            if(arr1[i]!=arr2[i]) ans++;
        }
        bw.write(ans+"");
        bw.close();
    }
}
