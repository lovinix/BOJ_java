import java.io.*;

public class Main17215
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        str = str.replaceAll("S",":");
        str = str.replaceAll("-","0");
        for(int i=0;i<str.length();++i)
        {
            if(str.charAt(i)=='P')
            {
                char c = (char)('0'+10-str.charAt(i-1)+'0');
                str = str.replaceFirst("P",String.valueOf(c));
            }
        }
        int[] frame = new int[12];
        int[] bonus = new int[12];
        for(int i=0,j=0;i<10||j<str.length();++i,++j)
        {
            frame[i]+=str.charAt(j)-'0';
            for(int k=1;k<=2;++k)
            {
                if(i-k<0) break;
                if(bonus[i-k]>0)
                {
                    frame[i-k]+=frame[i];
                    bonus[i-k]--;
                }
            }
            if(str.charAt(j)==':')
                bonus[i] = 2;
            else
            {
                if(j==str.length()-1) break;
                frame[i] +=str.charAt(++j)-'0';
                for(int k=1;k<=2;++k)
                {
                    if(i-k<0) break;
                    if(bonus[i-k]>0)
                    {
                        frame[i-k]+=str.charAt(j)-'0';
                        bonus[i-k]--;
                    }
                }
                if(str.charAt(j-1)+str.charAt(j)-'0'==':')
                    bonus[i] = 1;
            }
        }
        int ans = 0;
        for(int i=0;i<10;++i)
            ans+=frame[i];
        bw.write(ans+"");
        bw.close();
    }

}
