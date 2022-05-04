package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1]; // dp 테이블
		
		Arrays.fill(dp, -1);
		
		//dp[i] = dp[i-1] + 1 -> 1을 빼는경우
		// i % 2 == 0 -> dp[i] = min(d[i] , d[i/2] + 1) ->2로나눠지는경우
		// i % 3 == 0 -> dp[i] = min(d[i] , d[i/3] + 1) ->3로 나눠지는 경우
		
		dp[0] = 0;
		dp[1] = 0; //1까지도 연산 필요없음.
		//dp[2] = 1; // 최소연산 횟수. 1을 빼거나 , 2로 나누거나. 둘중 하나면 1 즉 1.
		
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1] + 1; // 기본적으로
			if(i % 2 == 0) dp[i] = Math.min(dp[i] , dp[i/2]+1);
			if(i % 3 == 0) dp[i] = Math.min(dp[i] , dp[i/3]+1);
		}
		
		System.out.println(dp[n]);
		
	}
	
	
}
