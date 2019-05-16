import java.io.*;

public class Main17205
{
    static long[] p = new long[10];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        p[0] = 1;
        for(int i=1;i<10;++i)
        {
            p[i] = p[i-1]*26;
        }
        String s = br.readLine();
        for(int i=0;i<s.length();++i)
        {
            ans += p[N-1-i]*(s.charAt(i)-'a')+1;
        }
        bw.write(ans+"");
        bw.close();
    }

}
