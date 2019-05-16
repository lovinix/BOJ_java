import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17208
{
    static int N,M,K;
    static Order[] od;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        od = new Order[N];
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            od[i] = new Order(c,p);
        }
        Arrays.sort(od);

        bw.close();
    }

}
class Order implements Comparable<Order>
{
    int c;
    int p;
    Order(int c, int p)
    {
        this.c = c;
        this.p = p;
    }
    public int compareTo(Order order)
    {
        if(this.c<order.c && this.p<order.p)
            return -1;
        if(this.c>order.c && this.p>order.p)
            return 1;
        return 0;
    }
}
