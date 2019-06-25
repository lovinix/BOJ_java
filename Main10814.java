import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main10814
{
    static ArrayList<Member> lst;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        lst = new ArrayList<>();
        while(N-->0)
        {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            lst.add(new Member(age,name));
        }
        Collections.sort(lst);
        for(Member member:lst)
        {
            bw.write(member.age+" "+member.name+"\n");
        }
        bw.close();
    }

}
class Member implements Comparable<Member>
{
    int age;
    String name;
    Member(int age,String name)
    {
        this.age = age;
        this.name =name;
    }
    public int compareTo(Member member)
    {
        return this.age-member.age;
    }
}
