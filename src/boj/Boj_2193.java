package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][2]; // [n][0] , [n][1] -> 0으로 끝나는경우랑 1로 끝나는 경우가 필요해. 근데 n범위가 90까지라 long형으로.
		
		dp[1][1] = 1; 
		dp[1][0] = 0; //첫번째가 0이면 이친수가 아니여.
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1]; // 0은 전에 0이든 1이든 상관없음. 
			dp[i][1] = dp[i-1][0]; //1이 연속으로 나올 수 없어.
		}
		
		System.out.println(dp[n][0] + dp[n][1]);	
		
	}
	
	
}
