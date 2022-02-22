package dynamic;

import java.util.Scanner;

public class IntTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = arr[i][j];
			}
		}
		
		//대각선 왼쪽 또는 대각선 오른쪽
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				int leftup, rightup;
				if(j==0) leftup = 0;
				else leftup = dp[i-1][j-1];
				
				if(j==i) rightup = 0;
				else rightup = dp[i-1][j];
				
				dp[i][j] = dp[i][j] + Math.max(rightup, leftup);
				
			}
		}
		
		int result =0;
		for(int i=0; i<n; i++) {
			result = Math.max(result , dp[n-1][i]);
		}
		System.out.println(result);
	}
}
