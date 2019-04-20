import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main15903
{
    static PriorityQueue<Long> q;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        q = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
        {
            q.offer(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; ++i)
        {
            long next = q.poll() + q.poll();
            q.offer(next);
            q.offer(next);
        }
        long ans = 0;
        while (!q.isEmpty())
        {
            ans += q.poll();
        }
        bw.write(ans + "");
        bw.close();
    }
}
