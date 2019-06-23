import java.io.*;
import java.util.StringTokenizer;

public class Main4600
{
    static Bridge[] arr;
    static int B, P;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while (!(s = br.readLine()).equals("0 0"))
        {
            StringTokenizer st = new StringTokenizer(s);
            B = -1 * Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            arr = new Bridge[2 * B + 1];
            for (int i = 0; i <= 2 * B; ++i)
                arr[i] = new Bridge(0, 0);
            arr[0].curh = P;
            for (int i = 1; i <= 2 * B; i += 2)
            {
                st = new StringTokenizer(br.readLine());
                arr[i].cap = Integer.parseInt(st.nextToken());
                arr[i].time = Integer.parseInt(st.nextToken());
            }
            int len = arr.length - 1;
            int ans = 0;
            while (arr[len].curh != P)
            {
                int t = Integer.MAX_VALUE;

                for (int i = len; i > 0; i -= 2)
                {
                    if (arr[i - 1].curt == 0)
                    {
                        arr[i].curh += arr[i - 1].curh;
                        arr[i - 1].curh = 0;
                    }
                    if (i != len && arr[i + 1].curh == 0 && arr[i].curh != 0)
                    {
                        arr[i + 1].curh = Math.min(arr[i].cap, arr[i - 1].curh);
                        arr[i].curh -= arr[i + 1].curh;
                        arr[i + 1].curt = arr[i + 1].time;
                        t = Math.min(t, arr[i + 1].curt);
                    }
                }
                for (int i = len - 1; i > 0; i -= 2)
                {
                    if (arr[i].curh == 0 && arr[i - 1].curh != 0)
                    {
                        arr[i].curh = Math.min(arr[i].cap, arr[i - 1].curh);
                        arr[i - 1].curh -= arr[i].curh;
                        arr[i].curt = arr[i].time;
                    }
                    if (arr[i].curt != 0) t = Math.min(t, arr[i].curt);
                }

                if (t != Integer.MAX_VALUE)
                {
                    for (int i = 1; i <= len; i += 2)
                        arr[i].curt -= arr[i].curt == 0 ? 0 : t;
                    ans += t;
                }
            }
            bw.write(ans + "\n");
        }
        bw.close();
    }

}

class Bridge
{
    int cap, time;
    int curh, curt;

    Bridge(int cap, int time)
    {
        this.cap = cap;
        this.time = time;
    }
}