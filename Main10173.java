import java.io.*;

public class Main10173
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        String[] cmp = {"NEMO","nemo"};
        loop1:while(!(s=br.readLine()).equals("EOI"))
        {
            loop2:for(int i=0;i<s.length()-3;)
            {
                for(int j=0;j<4;++j)
                {
                    if(s.charAt(i+j)!=cmp[0].charAt(j) && s.charAt(i+j)!=cmp[1].charAt(j))
                    {
                        i+=j+1;
                        continue loop2;
                    }
                }
                bw.write("Found\n");
                continue loop1;
            }
            bw.write("Missing\n");
        }
        bw.close();
    }

}
