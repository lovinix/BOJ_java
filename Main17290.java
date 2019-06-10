import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main434_10
{
    static ArrayList<Integer> candidate, bombcol;
    static char[][] arr;
    static int n,m;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken())-1;
        m = Integer.parseInt(st.nextToken())-1;
        arr = new char[10][10];
        candidate = new ArrayList<>(); bombcol = new ArrayList<>();
        for(int i=0;i<10;++i)
        {
            arr[i] = br.readLine().toCharArray();
            boolean flag = false;
            for(int j=0;j<10;++j)
            {
                if(arr[i][j] =='o')
                {
                    flag = true;
                    if(!bombcol.contains(j)) bombcol.add(j);
                }
            }
            if(flag) continue;
            candidate.add(i);
        }
        for(int i : candidate)
        {
            for(int j=0;j<10;++j)
            {
                if(!bombcol.contains(j))
                {
                    ans = Math.min(ans,Math.abs(n-i)+ Math.abs(m-j));
                }
            }
        }
        bw.write(ans+"");
        bw.close();
    }

}
