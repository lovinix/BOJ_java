import java.io.*;
import java.util.StringTokenizer;

public class Main17207
{
    static int[] ans = new int[5];
    static String[] name = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
    static int[][] a = new int[5][5];
    static int[] b = new int[5];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<5;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;++j)
            {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;++j)
            {
                b[i]+=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5;++i)
        {
            for(int j=0;j<5;++j)
            {
                ans[i]+=a[i][j]*b[j];
            }
        }
        int min = Integer.MAX_VALUE; int idx = -1;
        for(int i=0;i<5;++i)
        {
            if(ans[i]<=min)
            {
                min = ans[i];
                idx = i;
            }
        }
        bw.write(name[idx]);
        bw.close();
    }

}
