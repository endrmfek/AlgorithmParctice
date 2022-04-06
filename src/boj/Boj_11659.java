package boj;

import java.util.Scanner;

public class Boj_11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		int n = sc.nextInt();
		
		int[] arr = new int[data+1];
		int[] sum = new int[data+1];
		
		arr[0] = 0;
		sum[0] = 0;
		for(int i=1; i<data+1; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(sum[b]-sum[a-1]);
		}
				
	}
}
