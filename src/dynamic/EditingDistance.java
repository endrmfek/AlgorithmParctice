package dynamic;

import java.util.Scanner;

public class EditingDistance {
	
	static String a;
	static String b;
	
	static int editDist(String a, String b) {
		int n = a.length();
		int m = b.length();
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			dp[i][0] = i;
		}
		
		for(int j=1; j<=m; j++) {
			dp[0][j] = j;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if( a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		System.out.println(editDist(a, b));
		
	}
}
