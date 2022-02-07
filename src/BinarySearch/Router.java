package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Router {
	public static int n, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		c = sc.nextInt();
		
		int[] data = new int[n];
		for(int i=0; i<n; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		
		int start = 1; //최소거리
		int end = data[n-1] - data[0]; // 최대거리
		int result =0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int value = data[0]; // 첫집에 무적권 설치한다고 가정
			int cnt = 1;
			
			for(int i=0; i<n; i++) {
				if(data[i]>= value+mid) {
					value = data[i];
					cnt +=1;
				}
			}
			
			if(cnt >=c) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid -1;
			}
		}
		System.out.println(result);
		
	}
}
