import java.io.*;
import java.util.Arrays;

public class Main9251
{
    static char[] s1,s2;
    static int[][] dp;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        dp = new int[s1.length+1][s2.length+1];
        for(int i=0;i<=s1.length;++i)
            Arrays.fill(dp[i],-1);
        bw.write(recv(0,0)+"");
        bw.close();
    }
    public static int recv(int idx1,int idx2)
    {
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(idx1==s1.length || idx2==s2.length)
            return 0;
        if(s1[idx1]==s2[idx2])
            return dp[idx1][idx2] = recv(idx1+1,idx2+1)+1;
        else
            return dp[idx1][idx2] = Math.max(recv(idx1+1,idx2),recv(idx1,idx2+1));
    }

}
