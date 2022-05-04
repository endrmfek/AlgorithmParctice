package boj;

import java.util.Scanner;

public class Boj_10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[][] dp = new long[n+1][10]; // [길이][높이]
		
		for(int i=1; i<10; i++) {
			dp[1][i] = 1; // 길이가 1일때 높이가 0이올수없어.
		}
		
		for(int i=2; i<=n; i++) { // 길이에 대해서
			
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
			
			for(int j=1; j <9; j++) { // 높이에 대해서
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
		}
		
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum = (sum+dp[n][i]) % 1000000000;
		}
		
		System.out.println(sum);
	}
}
