import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main17219
{
    static HashMap<String,String> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;++i)
        {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String p = st.nextToken();
            hashMap.put(s,p);
        }
        for(int i=0;i<M;++i)
        {
            bw.write(hashMap.get(br.readLine())+"\n");
        }
        bw.close();
    }

}
