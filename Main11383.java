import java.io.*;
import java.util.StringTokenizer;

public class Main11383
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][2*M];
        char[][] cmp = new char[N][2*M];
        for(int i=0;i<N;++i)
        {
            char[] tmp = br.readLine().toCharArray();
            for(int j=0;j<M;j++)
            {
                arr[i][2*j] = tmp[j];
                arr[i][2*j+1] = tmp[j];
            }
        }
        for(int i=0;i<N;++i)
        {
            char[] tmp = br.readLine().toCharArray();
            for(int j=0;j<2*M;++j)
            {
                if (tmp[j] != arr[i][j])
                {
                    bw.write("Not Eyfa");
                    bw.close();
                    return;
                }
            }
        }
        bw.write("Eyfa");
        bw.close();

    }
}
