import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1517
{
    static int N;
    static int[] arr,tmp,tree = new int[4*(500000)];
    static Integer[] idx;
    static long ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N]; idx = new Integer[N]; tmp = new int[N];
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            idx[i] = i;
        }
        Arrays.sort(idx,(o1,o2)->arr[o1]-arr[o2]);
        Arrays.sort(arr);
        for(int i=0,val=1;i<N;)
        {
            int j=1;
            for(;i+j<N;++j)
            {
                if(arr[i]==arr[i+j])
                    arr[i+j]=val;
                else
                    break;
            }
            arr[i] = val++;
            i+=j;
        }
        for(int i=0;i<N;++i)
        {
            tmp[idx[i]] = arr[i];
        }
        arr = tmp;
        for(int i=0;i<N;++i)
        {
            ans += query(1,1,500000,arr[i]);
        }
        bw.write(ans+"");
        bw.close();
    }

    public static int query(int node, int start, int end, int val)
    {
        if(end<val) return 0;
        if(start>val) return tree[node];
        if(start==end)
        {
            ++tree[node];
            return 0;
        }
        ++tree[node];
        int mid = (start+end)/2;
        return query(node*2,start,mid,val)+query(node*2+1,mid+1,end,val);
    }
}