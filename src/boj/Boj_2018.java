package boj;

import java.util.Scanner;

public class Boj_2018 {
	public static void main(String[] args) { // 수들의 합
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 1; // N 그자체일때를 포함.
		int s_idx = 1;
		int e_idx = 1;
		int sum = 1;
		
		while(e_idx != N) {
			if(sum == N) {
				count++;
				e_idx++;
				sum = sum + e_idx;
			} else if(sum > N) {
				sum = sum - s_idx;
				s_idx++;
			} else { //sum < N
				e_idx++;
				sum = sum + e_idx;
			}
		}
		System.out.println(count);
	}
}
