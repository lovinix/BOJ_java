import java.io.*;
import java.util.PriorityQueue;

public class Main1927
{
    static PriorityQueue<Integer> q;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        q = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        while(N-->0)
        {
            int x = Integer.parseInt(br.readLine());
            if(x==0)
            {
                if(q.isEmpty()) bw.write("0\n");
                else bw.write(q.poll()+"\n");
            }
            else
            {
                q.offer(x);
            }
        }
        bw.close();
    }
}
