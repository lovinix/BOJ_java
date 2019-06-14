import java.io.*;

public class Main4631
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len,cnt=1;
        while((len=Integer.parseInt(br.readLine()))!=0)
        {
            String[] arr = new String[len];
            for(int i=0;i<len;++i)
            {
                arr[i%2==0?i/2:len-1-i/2]=br.readLine();
            }
            bw.write("SET "+ cnt++ +"\n");
            for(String s : arr)
                bw.write(s+"\n");
        }
        bw.close();
    }

}
