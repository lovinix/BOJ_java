import java.io.*;

public class Main17252
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==0)
        {
            System.out.print("NO"); return;
        }
        if(n%3==1) n--;
        while(n>1)
        {
            switch (n%3)
            {
                case 0 :
                    n/=3;
                    break;
                case 1 :
                    n--;
                    n/=3;
                    break;
                case 2 :
                    System.out.print("NO");
                    return;
            }
        }
        bw.write("YES");
        bw.close();
    }

}
