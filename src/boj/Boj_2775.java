package boj;

import java.util.Scanner;

public class Boj_2775 {
	public static void main(String[] args) {
		int[][] dp= new int[15][15];
		for(int i=0; i<15; i++) {
			dp[i][1] = 1;
			dp[0][i] = i;
		}
		
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j]; // i층에 j방 -> i층에 j-1방 + i-1층에 j방을 더해.
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int k=0 , n=0;
		while(tc-- > 0) {
			k = sc.nextInt();
			n = sc.nextInt();
			
			System.out.println(dp[k][n]);
		}
	}
}
