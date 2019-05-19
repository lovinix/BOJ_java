import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main1302
{
    static HashMap<String,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;++i)
        {
            String s = br.readLine();
            if(hashMap.containsKey(s))
                hashMap.put(s,hashMap.get(s)+1);
            else
                hashMap.put(s,1);
        }
        String maxs = "";
        int maxn = -1;
        for(Map.Entry<String,Integer> entry : hashMap.entrySet())
        {
            if(maxn<entry.getValue())
            {
                maxs = entry.getKey();
                maxn = entry.getValue();
            }
            else if(maxn == entry.getValue())
            {
                maxs = (maxs.compareTo(entry.getKey())<0)?maxs:entry.getKey();
            }
        }
        bw.write(maxs);
        bw.close();
    }

}
