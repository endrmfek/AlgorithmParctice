package dynamic;

import java.util.Scanner;

//m번에 걸쳐 오른쪽 위, 오른쪽, 오른쪽 아래

public class GoldMine {
	public static int testCase, n, m;
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];
	
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		testCase =sc.nextInt();
		for(int tc=0; tc<testCase; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					dp[i][j] = arr[i][j];
				}
			}
			
			for(int j=1; j<m; j++) {
				for(int i=0; i<n; i++) {
					int leftup, leftDown, left;
					//왼쪽 위에서 오는 경우
					if(i==0) leftup =0;
					else leftup = dp[i-1][j-1];
					
					if(i==n-1) leftDown = 0;
					else leftDown = dp[i+1][j-1];
					
					left = dp[i][j-1];
					dp[i][j] = dp[i][j] + Math.max(leftup , Math.max(leftDown, left));
				}
			}
			
			int result =0;
			for(int i=0; i<n; i++) {
				result = Math.max(result, dp[i][m-1]);
			}
			System.out.println(result);
		}
		
	}
}
