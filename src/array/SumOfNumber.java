package array;

import java.util.Scanner;

public class SumOfNumber {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.nextLine();
		
		int result = 0;
		String number = sc.nextLine();
		
		for(int i=0; i<number.length(); i++) {
			result += number.charAt(i) -'0';
		}
		
		System.out.println(result);
	}
	
}