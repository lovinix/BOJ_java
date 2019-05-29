import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main14425
{
    static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;++i)
            hashSet.add(br.readLine());
        int ans = 0;
        for(int i=0;i<m;++i)
            ans+=hashSet.contains(br.readLine())?1:0;
        bw.write(ans+"");
        bw.close();
    }

}
