import java.io.*;
import java.util.StringTokenizer;

public class Main437_4
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean p = false;
        for(int i=0;i<N;++i)
        {
            String[] cur = st.nextToken().split("[.]");
            if(cur.length==2)
            {
                sum+=Integer.parseInt(cur[0])+(p?0:1);
                p=true;
            }
            else
            {
                int next = Integer.parseInt(cur[0]);
                sum+=next;
                if(next>0) p=true;
            }
        }
        bw.write(sum+"");
        bw.close();
    }

}
