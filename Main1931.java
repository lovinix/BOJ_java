import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1931
{
    static ArrayList<Qwer> arrayList;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>();
        while(N-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayList.add(new Qwer(start,end));
        }
        Collections.sort(arrayList);
        int sum = 1;
        int cur = 0;
        for(int i=1,len=arrayList.size();i<len;++i)
        {
            if(arrayList.get(i).start<arrayList.get(cur).end) continue;
            cur = i;
            sum++;
        }
        bw.write(sum+"");
        bw.close();
    }
}

class Qwer implements Comparable<Qwer>
{
    int start;
    int end;
    Qwer(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
    public int compareTo(Qwer qwer)
    {
        return this.end<qwer.end?-1:this.end>qwer.end?1:this.start<qwer.start?-1:1;
    }

}
