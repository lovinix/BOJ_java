import java.io.*;

public class Main17214
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int idx = str.indexOf('x');
        sb.append(in(str.substring(0,idx+1)));
        sb.append(in(str.substring(idx+1)));
        sb.append(sb.length()==0?"W":"+W");
        bw.write(sb.toString());
        bw.close();
    }
    public static String in(String str)
    {
        if(str.equals("")) return "";
        int idx = str.indexOf('x');
        if(idx<0)
        {
            if(str.equals("1")) return "x";
            if(str.equals("+1")) return "+x";
            if(str.equals("-1")) return "-x";
            if(str.equals("0")) return "";
            return str+"x";
        }
        else
        {
            String sub = str.substring(0,idx);
            return sub.equals("2")?"xx":(sub.equals("-2")?"-xx":(Integer.parseInt(sub)/2+"xx"));
        }
    }
}
