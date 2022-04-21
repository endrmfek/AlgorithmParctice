package boj;

import java.util.Scanner;

public class Boj_11051 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n+1][n+1];
		
		for(int i=0; i<n+1; i++) {
			dp[i][0] = 1; // 하나도 안뽑는 경우 자체가 1
			dp[i][1] = i; // 한개를 뽑는 경우는 i
			dp[i][i] = 1; // i를 뽑는 경우가 자체가 1
		}
		
		for(int i=2; i<n+1; i++) { // 왜 2부터해? 1부터하면 뭘선택해?..
			for(int j=1; j<=i; j++) { //1부터 i까지
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1]; //i-1번째에서 j개를 다 뽑는경우 + i-1번째에서 j-1개를 뽑고 요번경우에서 하나 뽑는경우
				dp[i][j] = dp[i][j] % 10007;
			}
		}
		System.out.println(dp[n][k]);
	}
}
