import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1068
{
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        for(int i=0;i<N;++i)
            arr[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            int p = Integer.parseInt(st.nextToken());
            if(p!=-1)
                arr[p].add(i);
        }
        int tot = 0;
        int node = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
            tot+=arr[i].size()==0?1:arr[i].size()==1&&arr[i].get(0)==node?1:0;
        bw.write(tot-recv(node)+"");
        bw.close();
    }
    static int recv(int idx)
    {
        if(arr[idx].size()==0) return 1;
        int ret = 0;
        for(int next : arr[idx])
        {
            ret+=recv(next);
        }
        return ret;
    }
}
