import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17163
{
    static int Q, mod;
    static ArrayList<Integer>[] arr;
    static Stack<Integer> stk;
    static int[] tree;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());
        mod = Integer.parseInt(st.nextToken());
        if (mod > (int) 1e6)
        {
            while (Q-- > 0)
            {
                if (br.readLine().equals("3")) bw.write("-1\n");
            }
            bw.close();
            return;
        }
        stk = new Stack<>();
        arr = new ArrayList[mod];
        tree = new int[4 * (mod + 1)];
        for (int i = 0; i < mod; ++i)
        {
            arr[i] = new ArrayList<>();
            arr[i].add(-1);
            update(1, 0, mod - 1, i, -1);
        }
        while (Q-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            if (f == 1)
            {
                int num = Integer.parseInt(st.nextToken()) % mod;
                arr[num].add(stk.size());
                update(1, 0, mod - 1, num, stk.size());
                stk.push(num);
            }
            else if (f == 2)
            {
                if (stk.isEmpty()) continue;
                int val = stk.pop();
                arr[val].remove(arr[val].size() - 1);
                update(1, 0, mod - 1, val, arr[val].get(arr[val].size() - 1));
            }
            else
            {
                bw.write((tree[1] == -1 ? -1 : stk.size() - tree[1]) + "\n");
            }
        }
        bw.close();
    }

    public static void update(int n, int s, int e, int idx, int v)
    {
        if (s > idx || e < idx) return;
        if (s == e)
        {
            tree[n] = v;
            return;
        }
        int m = (s + e) / 2;
        update(n * 2, s, m, idx, v);
        update(n * 2 + 1, m + 1, e, idx, v);
        tree[n] = Math.min(tree[n * 2], tree[n * 2 + 1]);
    }
}