import java.io.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Main10866
{
    static HashMap<String,Integer> hashMap;
    static String[] tmp = {"push_front", "push_back","pop_front","pop_back","size","empty","front","back"};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();
        hashMap = new HashMap<>();
        for(int i=0;i<8;++i)
        {
            hashMap.put(tmp[i],i);
        }
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i)
        {
            String[] s = br.readLine().split(" ");
            int func = hashMap.get(s[0]);
            switch (func)
            {
                case 0:
                    deque.addFirst(Integer.parseInt(s[1]));
                    break;
                case 1:
                    deque.addLast(Integer.parseInt(s[1]));
                    break;
                case 2:
                    bw.write(deque.size()==0?"-1\n":(deque.pollFirst()+"\n"));
                    break;
                case 3:
                    bw.write(deque.size()==0?"-1\n":(deque.pollLast()+"\n"));
                    break;
                case 4:
                    bw.write(deque.size()+"\n");
                    break;
                case 5:
                    bw.write(deque.isEmpty()?"1\n":"0\n");
                    break;
                case 6:
                    bw.write(deque.size()==0?"-1\n":(deque.peekFirst()+"\n"));
                    break;
                case 7:
                    bw.write(deque.size()==0?"-1\n":(deque.peekLast()+"\n"));
                    break;
            }
        }
        bw.close();
    }

}
