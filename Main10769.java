import java.io.*;

public class Main10769
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int idx = s.indexOf(":-");
        int a=0,b=0;
        while(idx>=0 && idx<s.length()-2)
        {
            if(s.charAt(idx+2)==')') a++;
            else if(s.charAt(idx+2)=='(') b++;
            s=s.substring(idx+2);
            idx = s.indexOf(":-");
        }
        bw.write(a==b?(a==0?"none":"unsure"):(a>b?"happy":"sad"));
        bw.close();
    }

}
