import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5766
{
    static Num5766[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            arr = new Num5766[10001];
            for(int i=1;i<=10000;++i)
                arr[i] = new Num5766(i,0);
            for(int i=1;i<=N;++i)
                arr[i] = new Num5766(i,0);
            for(int i=0;i<N;++i)
            {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;++j)
                {
                    arr[Integer.parseInt(st.nextToken())].val++;
                }
            }
            Arrays.sort(arr,1,arr.length);
            int max = arr[1].val;
            int i = 1;
            for(;arr[i].val==max;++i);
            bw.write(arr[i].idx+"");
            for(++i;;++i)
            {
                if(arr[i].val==arr[i-1].val)
                    bw.write(" "+arr[i].idx);
                else
                    break;
            }
            bw.write("\n");
        }
        bw.close();
    }

}
class Num5766 implements Comparable<Num5766>
{
    int idx;
    int val;
    Num5766(int idx,int val)
    {
        this.idx = idx;
        this.val = val;
    }
    public int compareTo(Num5766 num5766)
    {
        return this.val==num5766.val?this.idx-num5766.idx:num5766.val-this.val;
    }
}