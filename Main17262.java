import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main417_6
{
    static int N;
    static Time417[] arr;
    static long ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new Time417[N];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Time417(start,end);
        }
        Arrays.sort(arr);
        int ans = 0;
        int first = arr[0].ed;
        for(int i=1;i<N;++i)
        {
            if(arr[i].st<=first)
                continue;
            else
            {
                ans = Math.max(ans,arr[i].st-first);
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
class Time417 implements Comparable<Time417>
{
    int st;
    int ed;
    Time417(int st,int ed)
    {
        this.st = st;
        this.ed = ed;
    }
    public int compareTo(Time417 time417)
    {
        return this.ed==time417.ed?this.st-time417.st:this.ed-time417.ed;
    }
}