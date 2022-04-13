package boj;

import java.util.Scanner;

public class Boj_1300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long start = 1;
		long end = k;
		long answer = 0;
		
		while(start<=end) {
			long mid = (start + end) /2;
			long cnt = 0;
			
			for(int i=1; i<=n; i++) { //각 행에서 중앙값보다 작은거 찾는거야
				cnt += Math.min(mid/i, n); // 핵심 로직. 이거 이해해야됨.
			}
			
			if(cnt<k) {
				start =  mid + 1;
			} else {
				answer = mid;
				end = mid-1;
			}
		}
		
		System.out.println(answer);
	}
}
