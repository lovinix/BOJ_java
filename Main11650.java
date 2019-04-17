import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11650
{
    static ArrayList<Loc> arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        while(N-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr.add(new Loc(n,m));
        }
        Collections.sort(arr);
        for(Loc loc : arr)
        {
            bw.write(loc.n+" "+loc.m+"\n");
        }
        bw.close();
    }

}
class Loc implements Comparable<Loc>
{
    int n;
    int m;
    Loc(int n,int m)
    {
        this.n = n;
        this.m = m;
    }
    public int compareTo(Loc loc)
    {
        return this.n<loc.n?-1:this.n>loc.n?1:this.m<loc.m?-1:1;
    }
}
