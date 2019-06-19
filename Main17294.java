import java.io.*;

public class Main437_2
{
    static String[] ans = {"◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!","흥칫뿡!! <(￣ ﹌ ￣)>"};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        if(input.length<=2)
        {
            System.out.print(ans[0]);
            return;
        }
        int dif = input[1]-input[0];
        for(int i=1;i<input.length;++i)
        {
            if(input[i]-input[i-1]!=dif)
            {
                System.out.print(ans[1]);
                return;
            }
        }
        System.out.print(ans[0]);
        bw.close();
    }

}
