package dynamic;

import java.util.Scanner;
// 아 이거 time = t[i] + i 부분을 모르겠습니다...
// n값이 문제 예시에는 7인데
// i값이 1~7이여서 1일부터 7일까지라고 생각하면 i + t[i] <= n 은 이해됩니다..
// 근데 실제 배열 i는 0~6까지잖아? 근데 이걸 일수로 따지면 0일에서 6일인데 i + t[i] <= n 이 어떻게 말이되지..

//할수있는 날들 중에서 최대 금액을 골라야겠지?
public class Leave {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int maxValue = 0;
		int[] t = new int[n]; //시간
		int[] p = new int[n]; //금액
		int[] dp = new int[n+1];
		 
		for(int i=0; i<n; i++) {  //0일 ~ 7일
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		//뒤에서부터
		for(int i=n-1; i>=0; i--) {
			int time = t[i] + i; // 오늘날짜 + 할일이 퇴사일을 넘으면 안돼
			
			if( time <= n) { //퇴사일을 넘어가지 않도록. 근데 + i가 실제 일수보다 하루적잖아?
				dp[i] = Math.max(p[i] + dp[time], maxValue );
				maxValue = dp[i];
			}
			else {
				dp[i] = maxValue;
			}
		}
		
		System.out.println(maxValue);
	}
}
