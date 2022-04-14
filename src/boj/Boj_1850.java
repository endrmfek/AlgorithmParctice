package boj;

import java.util.Scanner;

public class Boj_1850 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long result = gcd(a,b);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<result; i++) {
			sb.append("1");
		}
		
		System.out.println(sb.toString());
	}
	
	private static long gcd(long x, long y) {
		if(y == 0) {
			return x;
		} else {
			return gcd(y, x%y);
		}
		
	}
}
