import java.io.*;
import java.util.StringTokenizer;

public class Main1541
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int idx = s.indexOf('-');
        if(idx!=-1)
        {
            s = s.substring(0,idx)+s.substring(idx).replaceAll("\\+","-");
        }
        StringTokenizer st = new StringTokenizer(s,"+||-",true);
        int ans = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens())
        {
            String op = st.nextToken();
            if(op.equals("+"))
            {
                ans+=Integer.parseInt(st.nextToken());
            }
            else
            {
                ans-=Integer.parseInt(st.nextToken());
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
