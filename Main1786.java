import java.io.*;

public class Main1786
{
    static long[] pow = new long[1000001];
    static long mod = Long.MAX_VALUE >> 10;
    static String t, p;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("string.txt"));
        //BufferedWriter bw = new BufferedWriter(new FileWriter("stringout.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = br.readLine();
        p = br.readLine();
        if(t.length()<p.length())
        {
            bw.write("0");
            bw.close();
            return;
        }
        long phash = 0, thash = 0;
        int count = 0;
        pow[0] = 1;
        for (int i = 1; i <= 1000000; ++i)
        {
            pow[i] = (pow[i - 1] * 31) % mod;
        }
        for (int i = 0; i < p.length(); ++i)
        {
            phash = (phash * 31 + p.charAt(i)) % mod;
            thash = (thash * 31 + t.charAt(i)) % mod;
        }
        if (phash == thash)
        {
            count++;
            sb.append("1 ");
        }
        for (int i = 1; i <= t.length() - p.length(); ++i)
        {
            thash = (thash - (long) t.charAt(i - 1) * pow[p.length() - 1]) % mod;
            if (thash < 0) thash = mod + thash;
            thash = (31 * thash) % mod;
            thash = (thash + t.charAt(i + p.length() - 1)) % mod;
            if (phash == thash)
            {
                count++;
                sb.append((i + 1) + " ");
            }
        }
        bw.write(count + "\n" + sb.toString());
        bw.close();
    }

}
