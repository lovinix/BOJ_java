import java.io.*;
import java.util.*;

public class Main408_6
{
    static Stack<Ticket> stk = new Stack<>();
    static Queue<Ticket> q = new LinkedList<>();
    static ArrayList<Ticket> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
            {
                Ticket ticket = new Ticket(st.nextToken());
                arrayList.add(ticket);
                q.offer(ticket);
            }
        }
        Collections.sort(arrayList);
        int idx = 0;
        while(!(q.isEmpty()&&stk.isEmpty()))
        {
            if(!q.isEmpty() && q.peek() == arrayList.get(idx))
            {
                q.poll(); idx++; continue;
            }
            else
            {
                if(!stk.isEmpty() && stk.peek() == arrayList.get(idx))
                {
                    stk.pop(); idx++; continue;
                }
                else
                {
                    if(q.isEmpty())
                    {
                        System.out.print("BAD");
                        return;
                    }
                    else
                    {
                        stk.push(q.poll());
                    }
                }
            }
        }
        System.out.print("GOOD");
    }

}
class Ticket implements Comparable<Ticket>
{
    char c;
    int i;
    Ticket(String s)
    {
        c = s.charAt(0);
        i = Integer.parseInt(s.substring(2));
    }
    public int compareTo(Ticket ticket)
    {
        return this.c!=ticket.c?this.c-ticket.c:this.i-ticket.i;
    }
}
