package boj;

import java.util.Scanner;

public class Boj_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); //m이상
		int n = sc.nextInt(); //n이하 소수 찾기
		
		int[] number = new int[n+1];
		
		for(int i=2; i<n+1; i++) {
			number[i] = i;
		}
		
		for(int i=2; i<=Math.sqrt(n); i++) { // 최대 숫자의 제곱근까지만 탐색해도 됨.
			
			if(number[i] == 0) continue;
			
			for(int j=i+i; j<=n; j=j+i) { //첫번째 i는 그냥 냅두기 위해 
				//배수 지워
				number[j] = 0;
			}
		}
		
		for(int i=m; i<n+1; i++) {
			if(number[i] != 0) {
				System.out.println(number[i]);
			}
		}
	}
}
