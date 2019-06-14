import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1264
{
    static ArrayList<Character> arrayList;
    static Character[] arr = {'a','e','i','o','u','A','E','I','O','U'};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arrayList = new ArrayList<>(Arrays.asList(arr));
        String s;
        while(!(s=br.readLine()).equals("#"))
        {
            int ans = 0;
            for(int i=0;i<s.length();++i)
                ans+=arrayList.contains(s.charAt(i))?1:0;
            bw.write(ans+"\n");
        }
        bw.close();
    }

}
