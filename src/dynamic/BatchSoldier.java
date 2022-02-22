package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//최대? -> 다이나믹 아닙니까?
//최장증가 수열로 해결.
public class BatchSoldier {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//reverse를 위해 list선언.
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arr.add(sc.nextInt());
		}
		
		Collections.reverse(arr); // 오름차순으로 빠꿔
		
		int[] dp = new int[n]; //최장 증가 수열
		for(int i=0; i<n; i++) {
			dp[i] = 1;
		}
		
		// 로직 처리
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr.get(j) < arr.get(i)) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		//최장 증가 수열 만들었응게
		int maxValue = 0;
		for(int i=0; i<n; i++) {
			maxValue = Math.max(dp[i], maxValue);
		}
		
		System.out.println(n - maxValue);
	}
	
}
