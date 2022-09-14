package boj;

import java.util.Scanner;

public class Boj_2342 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][][] dp = new int[100001][5][5]; // [n][왼발][오른발]
		int[][] nextMove = {{0,2,2,2,2}, // 0->?
							{2,1,3,4,3}, // 1->?
							{2,3,1,3,4}, //2->?
							{2,4,3,1,3}, //3->?
							{2,3,4,3,1}}; //4->? 
		int n = 0, start= 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; i<100001; k++) {
					dp[k][i][j] = 100001 * 4; // 충분히 큰값으로 초기화를 하고
				}
			}
		}
		dp[0][0][0] = 0;
		
		while(true) { //시작을 해보자고.
			n = sc.nextInt(); // 수열을 하나씩 받아보자구요.
			
			if(n == 0 ) break; // 수열의 끝
			
			for(int i=0; i<5; i++) {
				if(n == i) continue; // 같은발이면 안되잖아.
				
				for(int j=0; j<5; j++) {
					//오른발에 대해
					dp[start][i][n] = Math.min(dp[start-1][i][j] + nextMove[j][n], dp[start][i][n]);
				}
			}
			
			for(int j=0; j<5; j++) {
				if(n == j) continue; // 두발이 똑같으면 안돼.
				
				for(int i=0; i<5; i++) {
					dp[start][n][j] = Math.min(dp[start-1][i][j] + nextMove[i][n] , dp[start][n][j]);
				}
			}
			
			
			start++;
		}
		start--;
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				min = Math.min(min , dp[start][i][j]);
			}
		}
		System.out.println(min);
	}
}
