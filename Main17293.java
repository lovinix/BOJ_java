import java.io.*;

public class Main437_3
{
    static String[] str = {"no more bottles","bottle","bottles"};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException
    {
        int N = Integer.parseInt(br.readLine());
        int a = N;
        while(N>=0)
        {
            p(N,1);
            bw.write(" of beer on the wall, ");
            p(N,0);
            bw.write(" of beer.\n");
            if(N>0)
                bw.write("Take one down and pass it around, ");
            else
                bw.write("Go to the store and buy some more, ");
            p(N>0?N-1:a,0);
            bw.write(" of beer on the wall.\n\n");
            N--;
        }
        bw.close();
    }

    public static void p(int n,int m) throws IOException
    {
        if(n==0)
        {
            if(m==0) bw.write(str[0]);
            else bw.write("No more bottles");
        }
        else if(n==1) bw.write(1+" "+str[1]);
        else bw.write(n+" "+str[2]);
    }
}
