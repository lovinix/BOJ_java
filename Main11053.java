import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11053
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens())
        {
            int next = Integer.parseInt(st.nextToken());
            if(next>arr.get(arr.size()-1))
            {
                arr.add(next);
                continue;
            }
            int idx = Collections.binarySearch(arr,next);
            if(idx<0)
            {
                arr.set(-idx-1,next);
            }
        }
        bw.write(arr.size()+"");
        bw.close();
    }

}
