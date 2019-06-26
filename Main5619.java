import java.io.*;
import java.util.PriorityQueue;

public class Main5619
{
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if(N==3)
        {

        }
        for(int i=0;i<N;++i)
        {
            pq.offer(Integer.parseInt(br.readLine()));
            if(pq.size()>4) pq.poll();
        }
        int[] tmp = new int[4];
        for(int i=0;i<4;++i)
            tmp[i] = pq.poll();
        bw.close();
    }

}
