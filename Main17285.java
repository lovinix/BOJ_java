import java.io.*;

public class Main434_3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] s = br.readLine().toCharArray();
        int key = s[0]^'C';
        for(char c : s)
            bw.write(c^key);
        bw.close();
    }

}
