package BinarySearch;

import java.util.Scanner;

public class Sequantial {
	
	public static int sequantialSearch(int n, String target, String[] arr) {
		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
			if(arr[i].equals(target)) {
				return i+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생성할 원소 개수와 한칸 뛰고 찾을 문자열 입력");
		int n = sc.nextInt();
		String target = sc.next();
		
		System.out.println("앞서 적은 원소 개수만큼 문자열을 입력해라. 구분은 띄어쓰기 한칸");
		String[] arr = new String[n];
		for(int i=0;i<n; i++) {
			arr[i] = sc.next();
		}
		
		System.out.println(sequantialSearch(n, target, arr));
		
	}
}
