import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17131
{
    static Star[] arr;
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new Star[N];
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Star(x,y);
        }
        Arrays.sort(arr,(o1,o2)->o1.y-o2.y);
        Arrays.sort(arr,(o1,o2)->o1.x-o2.x);

        bw.close();
    }

}
class Star
{
    int x,y;
    Star(int x,int y)
    {
        this.x=x;this.y=y;
    }
}