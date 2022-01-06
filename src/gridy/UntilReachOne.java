package gridy;

import java.util.Scanner;

public class UntilReachOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //25
		int k = sc.nextInt(); // 3
		int result = 0;
		
		while(true) {
			int target = (n/k) * k; //8*3
			result += (n-target); // 25-24 = 1
			n = target;
			if(n < k ) break; // 2<3
			
			result += 1; //2
			n = n / k; // 24/3 = 8
		}
		
		result += (n-1);
		System.out.println(result);
	}
}
