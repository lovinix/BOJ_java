import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main7568
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Size> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h =Integer.parseInt(st.nextToken());
            arr.add(new Size(h,w));
        }
        for(int i=0;i<N;++i)
        {
            Size cur = arr.get(i);
            int rank = 1;
            for(int j=0;j<N;++j)
            {
                if(cur.compareTo(arr.get(j))<-1) rank++;
            }
            sb.append(rank+" ");
        }
        bw.write(sb.toString().trim());
        bw.close();
    }

}
class Size implements Comparable<Size>
{
    int h;
    int w;
    Size(int h,int w)
    {
        this.h = h; this.w = w;
    }
    public int compareTo(Size size)
    {
        int ret = this.h>size.h?1:this.h==size.h?0:-1;
        ret += this.w>size.w?1:this.w==size.w?0:-1;
        return ret;
    }
}