import java.io.*;

public class Main424_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        if(N>=6)
        {
            System.out.print("Love is open door");
            return;
        }
        int a = Integer.parseInt(br.readLine());
        for(int i=0;i<N-1;++i)
        {
            bw.write((a^=1)+"\n");
        }
        bw.close();
    }

}
