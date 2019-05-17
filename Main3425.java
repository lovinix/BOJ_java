import java.io.*;
import java.util.HashMap;

public class Main3425
{
    static String[] com = {"NUM","POP","INV","DUP","SWP","ADD","SUB","MUL","DIV","MOD"};
    static HashMap<String,Integer> hashMap = new HashMap<>();
    static int[] stack = new int[1000];
    static int size,len;
    static String[] arr = new String[100001];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<10;++i)
            hashMap.put(com[i],i);
        String s;
        while(!(s=br.readLine()).equals("QUIT"))
        {
            size = 0; len = 0;
            while(!s.equals("END"))
                arr[len++] = s;
            int N = Integer.parseInt(br.readLine());
            program : while(N-->0)
            {
                size = 0;
                stack[size++] = Integer.parseInt(br.readLine());
                for(String func : arr)
                {
                    int f = hashMap.get(func.split(" ")[0]);
                    if( (f>2 && size<2)||(f>0 && size<1) )
                    {
                        bw.write("ERROR\n");
                        continue program;
                    }
                    switch (f)
                    {
                        case 0:
                            stack[size++] = Integer.parseInt(func.split(" ")[1]);
                            break;
                        case 1:
                            size--;
                            break;
                        case 2:
                            stack[size-1]*=-1;
                            break;
                        case 3:
                            stack[size]=stack[size-1];
                            size++;
                            break;
                        case 4:
                            stack[size-1]^=stack[size-2];
                            stack[size-2]^=stack[size-1];
                            stack[size-1]^=stack[size-2];
                            break;
                        case 5:
                            stack[size-2]+=stack[size-1];
                            if(Math.abs(stack[size-2])>1e9)
                            {
                                bw.write("ERROR\n");
                                continue program;
                            }
                            size--;
                            break;
                        case 6:
                            stack[size-2]-=stack[size-1];
                            if(Math.abs(stack[size-2])>1e9)
                            {
                                bw.write("ERROR\n");
                                continue program;
                            }
                            size--;
                            break;
                        case 7:
                            long tmp = (long)stack[size-2]*(long)stack[size-1];
                            if(Math.abs(tmp)>1e9)
                            {
                                bw.write("ERROR\n");
                                continue program;
                            }
                            stack[size-2]=(int)tmp;
                            size--;
                            break;
                        case 8:
                            if(stack[size-1]==0)
                            {
                                bw.write("ERROR\n");
                                continue program;
                            }
                            stack[size-2] = stack[size-2]/stack[size-1];
                            size--;
                            break;
                        case 9:
                            if(stack[size-1]==0)
                            {
                                bw.write("ERROR\n");
                                continue program;
                            }
                            stack[size-2] = stack[size-2]%stack[size-1];
                            size--;
                            break;
                    }

                }

            }

        }
        bw.close();
    }
}
