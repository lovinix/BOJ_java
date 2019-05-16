import java.io.*;

public class Main17201
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for(int i=0;i<arr.length-1;++i)
        {
            if(arr[i]==arr[i+1])
            {
                System.out.print("No");
                return;
            }
        }
        System.out.print("Yes");
        bw.close();
    }

}
