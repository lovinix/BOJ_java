import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main411_1
{
    static Task[] arr;
    static int N,L,K;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Task[N];
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            arr[i] = new Task(s1,s2);
        }
        Arrays.sort(arr, (o1,o2) ->
        {
           return o1.h>L&&o2.h>L?o1.e-o2.e:(o1.h==o2.h?o1.e-o2.e:o1.h-o2.h);
        });
        int ans = 0;
        for(int i=0;i<K;++i)
        {
            if(arr[i].h<=L) ans+=140;
            else if(arr[i].e<=L) ans+=100;
            else break;
        }
        bw.write(ans+"");
        bw.close();
    }

}
class Task
{
    int e;
    int h;
    Task(int e, int h)
    {
        this.e = e;
        this.h = h;
    }

}