import java.io.*;
import java.util.HashMap;

public class Main5656
{
    static HashMap<String,Integer> hashMap;
    static String[] op = {">",">=","<","<=","==","!="};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hashMap = new HashMap<>();
        for(int i=0;i<6;++i)
        {
            hashMap.put(op[i],i);
        }
        String[] s;
        int c = 1;
        do
        {
            s = br.readLine().split(" ");
            if(s[1].equals("E")) break;
            int func = hashMap.get(s[1]);
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[2]);
            bw.write("Case "+c+": ");
            switch (func)
            {
                case 0:
                    bw.write(a>b?"true":"false");
                    break;
                case 1:
                    bw.write(a>=b?"true":"false");
                    break;
                case 2:
                    bw.write(a<b?"true":"false");
                    break;
                case 3:
                    bw.write(a<=b?"true":"false");
                    break;
                case 4:
                    bw.write(a==b?"true":"false");
                    break;
                case 5:
                    bw.write(a!=b?"true":"false");
                    break;
            }
            bw.write("\n");
            ++c;
        }while(true);
        bw.close();
    }
}
