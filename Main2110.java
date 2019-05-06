import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0;i<N;++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = arr[0];
        int right = arr[arr.length-1];
        while(true)
        {
            int bef = arr[0], num = C-1;
            int gap = (right+left)/2;
            for(int i : arr)
            {
                if(i-bef>=gap)
                {
                    bef = i;
                    num--;
                }
            }
            if(num<=0)
            {
                if(left==right)
                {
                    System.out.print(gap);
                    return;
                }
                left = gap;
                if(right==left+1)
                {
                    right = gap;
                }
            }
            else
            {
                right = gap;
            }
        }
    }

}
