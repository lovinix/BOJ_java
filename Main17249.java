import java.io.*;

public class Main17249
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int idx = s.indexOf("0");
        String l = s.substring(0,idx);
        String r = s.substring(idx+1);
        int left=0,right=0;
        for(int i=0;i<l.length();++i)
            if(l.charAt(i)=='@') left++;
        for(int i=0;i<r.length();++i)
            if(r.charAt(i)=='@') right++;
        bw.write(left+" "+right);
        bw.close();
    }

}
