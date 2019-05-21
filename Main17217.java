import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17217
{
    static HashMap<Character,Integer> hashMap = new HashMap<>();
    static int[] arr = new int[26];
    static int T;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hashMap.put('S',0); hashMap.put('C',1); hashMap.put('D',2); hashMap.put('H',3);
        T = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i=0;i<26;++i)
        {
            char c = s.charAt(i);
            arr[i] = c=='S'?0:c=='C'?1:c=='D'?2:3;
        }
        int index = 0;
        for(int tc=0;tc<T;++tc)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S,C,D,H;
            switch (st.nextToken().charAt(0))
            {
                case 'E':
                    S = hashMap.get('S');
                    C = hashMap.get('C');
                    hashMap.put('S',C); hashMap.put('C',S);
                    D = hashMap.get('D');
                    H = hashMap.get('H');
                    hashMap.put('D',H); hashMap.put('H',D);
                    break;
                case 'R':
                    S = hashMap.get('S');
                    H = hashMap.get('H');
                    hashMap.put('S',H); hashMap.put('H',S);
                    C = hashMap.get('C');
                    D = hashMap.get('D');
                    hashMap.put('C',D); hashMap.put('D',C);
                    break;
                case 'G' :
                    index = (index+26+(-1*Integer.parseInt(st.nextToken()))%26)%26;
                    break;
                case 'T':
                    int id = Integer.parseInt(st.nextToken())-1;
                    arr[(index+id)%26] = hashMap.get(st.nextToken().charAt(0));
                    break;
                case 'A':
                    char[] cd = new char[4];
                    for(Map.Entry<Character,Integer> entry : hashMap.entrySet())
                    {
                        cd[entry.getValue()] = entry.getKey();
                    }
                    for(int i=0;i<26;++i)
                    {
                        bw.write(cd[arr[(index+i)%26]]);
                    }
                    bw.write("\n");
                    break;
            }
        }
        bw.close();
    }

}
