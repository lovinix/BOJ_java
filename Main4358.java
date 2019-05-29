import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main4358
{
    static int sum;
    static TreeMap<String,Integer> treeMap = new TreeMap<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s=br.readLine())!=null)
        {
            if(treeMap.containsKey(s))
                treeMap.put(s, treeMap.get(s)+1);
            else
                treeMap.put(s,1);
            ++sum;
        }
        for(Map.Entry<String,Integer> entry : treeMap.entrySet())
        {
            bw.write(entry.getKey()+" "+String.format("%.4f",entry.getValue()*100/(double)sum)+"\n");
        }
        bw.close();
    }

}
