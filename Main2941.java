import java.util.Scanner;
public class Main2941{
    public static void main(String[] args){
        System.out.print(new Scanner(System.in).nextLine().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "!").length());
    }
}
