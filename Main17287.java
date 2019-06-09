import java.io.*;

public class Main434_5
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int  cur = 0;
        char[] arr = br.readLine().toCharArray();
        int ans= 0;
        for(char c : arr)
        {
            switch (c)
            {
                case '(' : ++cur; break;
                case ')' : --cur; break;
                case '{' : cur+=2; break;
                case '}' : cur-=2; break;
                case '[' : cur+=3; break;
                case ']' : cur-=3; break;
                default: ans = Math.max(ans,cur);
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
