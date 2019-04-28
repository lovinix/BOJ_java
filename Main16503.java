import java.io.*;
import java.util.StringTokenizer;

public class Main16503
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k1 = Integer.parseInt(st.nextToken());
        String o1 = st.nextToken();
        int k2 = Integer.parseInt(st.nextToken());
        String o2 = st.nextToken();
        int k3 = Integer.parseInt(st.nextToken());
        bw.write(Math.min(cal(cal(k1,o1,k2),o2,k3),cal(k1,o1,cal(k2,o2,k3)))+"\n");
        bw.write(Math.max(cal(cal(k1,o1,k2),o2,k3),cal(k1,o1,cal(k2,o2,k3)))+"");
        bw.close();
    }

    public static int cal(int k1,String o1,int k2)
    {
        if(o1.equals("+"))
            return k1+k2;
        if(o1.equals("*"))
            return k1*k2;
        if(o1.equals("/"))
            return k1/k2;
        if(o1.equals("-"))
            return k1-k2;
        return 0;
    }
}
