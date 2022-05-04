package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_14501 { // DP. 얼마나 더 벌고 퇴사할거야?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int[] dp = new int[n+2]; // 나중에 점화식때문에 인덱스가 오버돼서 n+2로 초기화.
		int[] time = new int[n+1];
		int[] pay = new int[n+1];
		
		for(int i=1; i<n+1; i++) { //입력값 초기화
			time[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		
		//dp테이블 짜야됨. 바텀 업 방식으로
		//마지막날부터 첫날까지 점진적으로 누적해가는 방식으로 해결
		for(int i=n; i>0; i++) { //마지막날부터 첫재날까지 거꾸로
			
			if(i + time[i] > n+1) { //오늘부터 일을 끝내는 시간이 퇴사날을 넘겨버리면
				dp[i] = dp[i+1]; // 앞날이 계산이 되어있다고 가정을 함.
			} else {
				dp[i] = Math.max(dp[i+1], pay[i] + dp[i + time[i]]);
			}
		}
		
		System.out.println(dp[1]);
	}
}
