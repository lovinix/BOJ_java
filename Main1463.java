import java.util.Scanner;

public class Main1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] dp = new int[1000001];
		dp[1]=0; dp[2]=1; dp[3]=1;
		for(int i=4;i<=x;i++)
		{
			int a = i%3==0?dp[i/3]+1:Integer.MAX_VALUE;
			int b = i%2==0?dp[i/2]+1:Integer.MAX_VALUE;
			dp[i] = Math.min(dp[i-1]+1, Math.min(a, b));
			if(dp[i-1]+1< Math.min(a,b) && i%3==0)
				System.out.println((dp[i-1]+1)+" "+(dp[i/3]+1)+" "+i);
		}
		System.out.println(dp[x]);
	}
}