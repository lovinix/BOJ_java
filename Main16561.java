import java.io.*;

public class Main16561_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        if(N<9)
        {
            System.out.print(0);
            return;
        }
        int ans = 0;
        for(int i=3;i<=N-6;i+=3)
        {
            for(int j=3;;j+=3)
            {
                if(N-i-j<3) break;
                else ans++;
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
