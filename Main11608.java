import java.io.*;
import java.util.Arrays;

public class Main11608
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        int[] cnt = new int[26];
        int sum = 0;
        for(char c : arr)
        {
            cnt[c-'a']++;
            sum++;
        }
        int max=Integer.MIN_VALUE;
        Arrays.sort(cnt);
        sum-=cnt[25]+cnt[24];
        bw.write(sum+"");
        bw.close();
    }
}
