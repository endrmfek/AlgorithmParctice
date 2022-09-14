package boj;

import java.util.Scanner;

public class Boj_11409 {

	static class Matrix {
		int x;
		int y;
		public Matrix(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int n;
	static Matrix[] m;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new Matrix[n+1];
		dp = new int[n+1][n+1];
		
		for(int i=0; i<dp.length; i++) {
			for (int j=0; j<dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i=1; i<=n; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			m[i] = new Matrix(y, x);
		}
	}
	
}
