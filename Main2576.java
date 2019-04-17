import java.io.*;

public class Main2576
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<7;++i)
        {
            int cur =Integer.parseInt(br.readLine());
            if(cur%2==1)
            {
                sum+=cur;
                min= Math.min(min,cur);
            }
        }
        bw.write(sum==0?"-1":(sum+"\n"+min));
        bw.close();
    }
}
