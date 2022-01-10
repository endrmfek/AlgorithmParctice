package implement;

import java.util.Scanner;

//쓸때 없는 변수를 너무 많이 사용함.
//나동빈님께서는 한가지 변수를 사용해 반은 더하고 반은 빼서 0이되면 조건을 만족하는 방법으로 해결.

public class LuckyStrike {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		int len = data.length()/2;
		int a = 0;
		int b = 0;
		
		for(int i=0; i<len; i++) {
			int temp = data.charAt(i) - '0';
			a += temp;
		}
		
		for(int j=len; j<data.length(); j++) {
			int temp = data.charAt(j) -'0';
			b += temp;
		}
		
		if( a==b) {
			System.out.println("Lucky");
		} else {
			System.out.println("Ready");
		}
		
		
	}
}
