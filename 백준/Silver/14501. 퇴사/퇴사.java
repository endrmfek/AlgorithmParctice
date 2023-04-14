import java.util.Arrays;
import java.util.Scanner;

public class Main { // DP. 얼마나 더 벌고 퇴사할거야?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+2]; // 오늘부터 퇴사일까지. 왜 +2 일까?
		int[] time = new int[n+1]; //날짜
		int[] pay = new int[n+1]; //비용
		
		for(int i=1; i<n+1; i++) { // 초기화
			time[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		
		//dp 구해야지.
		
		for(int i=n; i>0; i--) { // 거꾸로간다.
			
			if(i+time[i] > n+1) { //날짜가 퇴사일을 넘어가면?
				
				dp[i] = dp[i+1]; // 이거때문에 dp를 n+2로 했구나.
			} else { // 퇴사안에있으면
							
				dp[i] = Math.max(dp[i+1], pay[i] + dp[i + time[i]]);
			}
		}
		System.out.println(dp[1]);
		
	}

}
