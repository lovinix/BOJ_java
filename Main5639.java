import java.io.*;

public class Main5639
{
    static int[] arr = new int[10000];
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException
    {

        String s;
        while((s=br.readLine())!=null)
            arr[n++] = Integer.parseInt(s);
        recv(0,n-1);
        bw.close();
    }
    public static void recv(int left,int right) throws IOException
    {
        if(left>right) return;
        int l = left, r = right;
        int root = left;
        while(arr[l]>=arr[root]) l++;
        while(arr[r]>arr[root]) r--;
        recv(l,r);
        recv(r+1,right);
        bw.write(arr[root]+"\n");
    }
}
