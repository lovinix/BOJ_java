import java.io.*;

public class Main434_7_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        char[] alpha = new char[26];
        for(int i=0;i<26;++i)
            alpha[i] = (char)('A'+i);
        int[] idx = new int[8];
        for(int i=0;i<8;++i)
            idx[i] = "CHICKENS".charAt(i)-'A';
        StringBuilder sb = new StringBuilder();
        for(int a = 0;a<input.length;++a)
        {
            char cur = input[a];
            for(int i=0;i<8;++i)
            {
                cur = alpha[(idx[i]+cur-'A')%26];
                if(i==0) idx[i] = (idx[i]+1)%26;
            }
            sb.append(cur);
        }
        bw.write(sb.toString());
        bw.close();
    }

}
