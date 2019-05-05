import java.io.*;
import java.util.TreeMap;

public class Main2957_2
{
    static TreeMap<Integer,Integer> treeMap = new TreeMap<>();
    static long cnt = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int root = Integer.parseInt(br.readLine());
        treeMap.put(root,1);
        bw.write("0\n");
        for(int i=1;i<N;++i)
        {
            int cur = Integer.parseInt(br.readLine());
            if(cur<root)
            {
                int max = Math.max(treeMap.get(treeMap.ceilingKey(cur)),
                        treeMap.floorKey(cur)==null?-1:treeMap.get(treeMap.floorKey(cur)));
                cnt+=max;
                treeMap.put(cur,max+1);
            }
            else
            {
                int max = Math.max(treeMap.get(treeMap.floorKey(cur)),
                        treeMap.ceilingKey(cur)==null?-1:treeMap.get(treeMap.ceilingKey(cur)));
                cnt+=max;
                treeMap.put(cur,max+1);
            }
            bw.write(cnt+"\n");
        }
        bw.close();
    }

}
