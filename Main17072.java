import java.io.*;
import java.util.StringTokenizer;

public class Main398_1
{
    static char[] ascii = {'#','o','+','-','.'};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;++j)
            {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bw.write(ascii[intensity(r,g,b)]);
            }
            bw.newLine();
        }
        bw.close();
    }
    public static int intensity(int r, int g, int b)
    {
        int ret = (2126*r + 7152*g + 722*b)/510000;
        return ret>4?4:ret;
    }

}
