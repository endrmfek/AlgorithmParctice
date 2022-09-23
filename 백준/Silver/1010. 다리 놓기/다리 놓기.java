import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		long[][] dp = new long[31][31];
		for(int i=0; i<=30; i++) {
			dp[i][1] = i;
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		
		for(int i=2; i<=30; i++) {
			for(int j=1; j<i; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; 
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0; i<tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(dp[m][n]);
		}
	}
}
