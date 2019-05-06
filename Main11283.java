import java.io.*;

public class Main11283
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char c = br.readLine().charAt(0);
        bw.write((c-'가'+1)+"");
        bw.close();
    }

}
