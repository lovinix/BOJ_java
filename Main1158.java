import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1158
{
    static LinkedList<Integer> linkedList = new LinkedList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;++i)
        {
            linkedList.add(i+1);
        }
        Iterator<Integer> it = linkedList.listIterator(K-1);
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            sb.append((it.hasNext()?it.next():(it=linkedList.iterator()).next())+", ");
            it.remove();
            if(linkedList.isEmpty()) break;
            for(int i=0;i<K-1;++i)
            {
                if(it.hasNext()) it.next();
                else
                {
                    it = linkedList.iterator();
                    i--;
                }
            }
        }
        bw.write("<"+sb.substring(0,sb.length()-2)+">");
        bw.close();
    }

}
