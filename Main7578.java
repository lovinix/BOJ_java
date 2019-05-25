import java.io.*;
import java.util.StringTokenizer;

public class Main7578
{
    static int[] idxarr = new int[1000001];
    static int[] arrb,sorted;
    static int N;
    static long ans;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i)
        {
            idxarr[Integer.parseInt(st.nextToken())]=i;
        }
        st = new StringTokenizer(br.readLine());
        arrb = new int[N];
        sorted = new int[N];
        for(int i=0;i<N;++i)
        {
            arrb[i] = Integer.parseInt(st.nextToken());
        }
        mergesort(0,N-1);
        bw.write(ans+"");
        bw.close();
    }
    public static void mergesort(int left, int right)
    {
        int mid = (left+right)/2;
        if(left<right)
        {
            mergesort(left,mid);
            mergesort(mid+1,right);
            merge(left,mid,right);
        }
    }
    public static void merge(int left,int mid,int right)
    {
        int i,j,k;
        i = left;
        j = mid+1;
        k = left;
        int acc = 0;
        while(i<=mid && j<=right)
        {
            if(idxarr[arrb[i]]<idxarr[arrb[j]])
            {
                sorted[k++] = arrb[i++];
                ans+=acc;
            }
            else
            {
                sorted[k++] = arrb[j++];
                acc++;
            }
        }
        while(i<=mid)
        {
            sorted[k++] = arrb[i++];
            ans+=acc;
        }
        while(j<=right)
        {
            sorted[k++] = arrb[j++];
        }
        for(i=left;i<=right;++i)
        {
            arrb[i] = sorted[i];
        }
    }
}
