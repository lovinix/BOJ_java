import java.io.*;
import java.util.StringTokenizer;

public class Main2745
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] ar = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i=ar.length-1;i>=0;--i)
        {
            ans+=(Character.isUpperCase(ar[i])?ar[i]-'A'+10:ar[i]-'0')*(int)Math.pow(n,ar.length-1-i);
        }
        bw.write(ans+"");
        bw.close();
    }
}
