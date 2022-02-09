package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class SpecificNumber {
	
	public static int upperBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			System.out.println("upper end = " + end);
			int mid = (start+end) /2 ;
			if(arr[mid] > target) end = mid;
			else start = mid+1;
		}
		return end;
	}
	
	public static int lowerBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			System.out.println("lower end = " + end);
			int mid = (start+end) /2 ;
			if(arr[mid] >= target) end = mid;
			else start = mid+1;
		}
		return end;
	}
	
	public static int count(int[] arr, int left, int right) {
		int leftIndex = lowerBound(arr, left, 0, arr.length);
		int rightIndex = upperBound(arr, right, 0, arr.length);
		return rightIndex - leftIndex;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = count(arr, x, x);
		
		if(cnt == 0) System.out.println(-1);
		else System.out.println(cnt);
		 
	}
}
