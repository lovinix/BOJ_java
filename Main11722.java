import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11722
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr.add(Integer.parseInt(st.nextToken()));
        while(N-->1)
        {
            int next = Integer.parseInt(st.nextToken());
            if(next<arr.get(arr.size()-1))
            {
                arr.add(next);
                continue;
            }
            int idx = Collections.binarySearch(arr,next,((o1, o2) -> Integer.compare(o2,o1)));
            if(idx<0)
            {
                idx = -idx - 1;
                arr.set(idx, next);
            }
        }
        bw.write(arr.size()+"");
        bw.close();
    }
}
