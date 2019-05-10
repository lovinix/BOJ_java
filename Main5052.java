import java.io.*;
import java.util.HashSet;

public class Main5052B
{
    static HashSet<String> prefix = new HashSet<>();
    static HashSet<String> num = new HashSet<>();
    public static void main(String[] args) throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("phone.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++)
        {
            prefix.clear();
            num.clear();
            int N = Integer.parseInt(br.readLine());
            boolean flag = false;
            for(int i=0;i<N;++i)
            {
                String s = br.readLine();
                for(int j=1;j<s.length();++j)
                {
                    if(num.contains(s.substring(0,j)))
                    {
                        flag = true;
                        break;
                    }
                }
                if(prefix.contains(s))
                    flag = true;
                if(!flag)
                {
                    for(int j=1;j<s.length();++j)
                    {
                        prefix.add(s.substring(0,j));
                    }
                    num.add(s);
                }
            }
            bw.write(flag?"NO\n":"YES\n");
        }
        bw.close();
    }

}
