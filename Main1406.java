import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main1406
{
    static LinkedList<Character> linkedList = new LinkedList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        for(char c : arr)
        {
            linkedList.add(c);
        }
        ListIterator<Character> it = linkedList.listIterator(arr.length);
        int N = Integer.parseInt(br.readLine());
        while(N-->0)
        {
            char[] tmp = br.readLine().toCharArray();
            if(tmp[0] == 'L')
            {
                if(it.hasPrevious()) it.previous();
            }
            else if(tmp[0] == 'D')
            {
                if(it.hasNext()) it.next();
            }
            else if(tmp[0] == 'B')
            {
                if(it.hasPrevious())
                {
                    it.previous(); it.remove();
                }
            }
            else if(tmp[0] == 'P')
            {
                it.add(tmp[2]);
            }
        }
        StringBuilder sb = new StringBuilder();
        it = linkedList.listIterator();
        while(it.hasNext())
        {
            sb.append(it.next());
        }
        bw.write(sb.toString());
        bw.close();
    }

}
