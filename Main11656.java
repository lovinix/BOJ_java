import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main11656
{
    static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for(int i=0;i<s.length();++i)
        {
            arr.add(s.substring(i));
        }
        Collections.sort(arr);
        for(String str : arr)
        {
            bw.write(str+"\n");
        }
        bw.close();
    }

}
