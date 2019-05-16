import java.io.*;

public class Main17202
{
    static int[][] arr = new int[10][10];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();

        for(int i=0;i<10;++i)
        {
            for(int j=0;j<10;++j)
            {
                arr[i][j] = (i+j)%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<8;++i)
        {
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }
        while(sb.length()>2)
        {
            StringBuilder tmp = new StringBuilder();
            for(int i=0;i<sb.length()-1;++i)
            {
                tmp.append(arr[sb.charAt(i)-'0'][sb.charAt(i+1)-'0']);
            }
            sb = tmp;
        }
        bw.write(sb.toString());
        bw.close();
    }

}
