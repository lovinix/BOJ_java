import java.io.*;
import java.util.StringTokenizer;

public class Main2083
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(name.equals("#") && age==0 && w == 0)
                break;
            if(age>17 || w>=80)
                bw.write(name+" Senior\n");
            else
                bw.write(name + " Junior\n");
        }
        bw.close();
    }

}
