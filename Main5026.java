import java.io.*;

public class Main5026
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            String s = br.readLine();
            if(s.equals("P=NP"))
            {
                bw.write("skipped\n");
            }
            else
            {
                bw.write((Integer.parseInt(s.substring(0,s.indexOf('+')))+Integer.parseInt(s.substring(s.indexOf('+')+1)))+"\n");
            }
        }
        bw.close();
    }

}
