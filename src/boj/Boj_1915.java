package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1915 { // 가장 큰 정사각형.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long[][] dp = new long[n][m];
		
		sc.nextLine(); // 버퍼 초기화
		
		
		//정사각형 넓이 -> 정사각형의 한변만 구하면돼.
		long side = 0;
		
		for(int i=0; i<n; i++) {
			
			String row = sc.nextLine();
			
			for(int j=0; j<m; j++) {
				
				dp[i][j] = Long.valueOf(String.valueOf(row.charAt(j)));
				
				if(dp[i][j] == 1 && j>0 && i>0) { // i, j 값이 무조건 1부터시작해야 인덱스 오류 나지 않음.
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + dp[i][j];
				}
				
				if(side < dp[i][j]) {
					side = dp[i][j];
				}
				
			}
		}
		
		
		System.out.println(side*side);
	}
}
