import java.io.*;

public class Main434_6
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = (br.readLine()+" ").toCharArray();
        int dif = 0; int j = 0; boolean flag = false;
        int ans = 0;
        for(int i=1;i<arr.length;++i)
        {
            if(flag == false)
            {
                if (Math.abs(arr[i] - arr[i - 1]) == 1)
                {
                    j = i - 1;
                    dif = arr[i] - arr[i - 1];
                    flag = true;
                }
            }
            else
            {
                if(arr[i]-arr[i-1] != dif)
                {
                    int len = i-j;
                    if(len==3) ans++;
                    flag = false;
                }
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
