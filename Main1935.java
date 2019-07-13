import java.io.*;
import java.util.Stack;

public class Main1935
{
    static int N;
    static double[] arr;
    static String s;
    static Stack<Double> stk = new Stack<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        s = br.readLine();
        arr = new double[N];
        for(int i=0;i<N;++i)
            arr[i]= Double.parseDouble(br.readLine());
        for(int i=0;i<s.length();++i)
        {
            if(Character.isUpperCase(s.charAt(i)))
            {
                stk.push(arr[s.charAt(i)-'A']);
            }
            else
            {
                double b = stk.pop();
                double a = stk.pop();
                stk.push(func(a,b,s.charAt(i)));
            }
        }
        bw.write(String.format("%.2f",stk.pop())+"");
        bw.close();
    }
    public static double func(double a, double b, char c)
    {
        switch (c)
        {
            case '*':
                return a*b;
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '/':
                return a/b;
                default :
                    return 0;

        }
    }
}
