import java.io.*;

public class Main2999
{
    static char[][] arr;
    static int r,c;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int len = s.length();
        for(int i=(int) Math.sqrt(len);i>0;--i)
        {
            if(len%i==0)
            {
                r=i;
                c=len/i;
                break;
            }
        }
        arr = new char[r][c];
        for(int i=0;i<c;++i)
        {
            for(int j=0;j<r;++j)
            {
                arr[j][i] = s.charAt(i*r+j);
            }
        }
        for(int i=0;i<r;++i)
        {
            for(int j=0;j<c;++j)
            {
                bw.write(arr[i][j]);
            }
        }
        bw.close();
    }

}
