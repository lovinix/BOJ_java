import java.io.*;

public class Main1356
{
    static long f=1,b=1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        int cnt = 0;
        for(char c : input)
            cnt+=c=='0'?1:0;
        if(cnt>0||input.length==1)
        {
            System.out.print(cnt==1||input.length==1?"NO":"YES");
            return;
        }
        f = input[0]-'0';
        for(int i=1;i<input.length;++i)
            b*=input[i]-'0';
        if(f==b)
        {
            System.out.print("YES");
            return;
        }
        for(int i=1;i<input.length-1;++i)
        {
            f*=input[i]-'0';
            b/=input[i]-'0';
            if(f==b)
            {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
        bw.close();
    }

}
