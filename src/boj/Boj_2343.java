package boj;

import java.util.Scanner;

public class Boj_2343 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 노래개수
		int m = sc.nextInt(); // 블루레이 개수
		
		int[] data = new int[n];
		
		int start = 0;
		int end = 0;
		
		for(int i=0; i<n; i++) {
			data[i] = sc.nextInt();
			if(start < data[i]) start = data[i]; // start를 최대값
			end += data[i];
		}
		
		//이진탐색 시작
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			
			for(int i=0; i<n; i++) {
				if(sum + data[i] > mid) { // 다음 데이터를 담았을때 넘치는걸 확인 '만' 하는거
					count++;	//넘치기 전에 카운트 올리고
					sum = 0;
				}
				sum = sum + data[i]; // 다음데이터는 data[i]부터 시작.
			}
			
			if(sum != 0) { //합이 남아있으면
				count++;
			}
			
			if(count>m) {	//블루레이가 넘치면 길이 다시 조정해야지
				start = mid+1;
			} else {	//안넘치면 최대한 조정해야지
				end = mid-1;
			}
//			System.out.println(count);
		}
		System.out.println(start);
	}
}
