package gridy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//N개의 동전 -> 만들수없는 정수 금액 중 최솟값을 구해!
// 아 이거 존나어려움.. 왜 난이도 1임?
// 이거 원리 꼭 기억해놔라. 쉽지않아


public class CantMakeAmount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> moneys = new ArrayList<>();
		
		int result =1;
		
		for(int i=0; i<n; i++) {
			moneys.add(sc.nextInt());
		}
		
		Collections.sort(moneys);
		
		for(int money : moneys) {
			if(result < money) {
				break;
			}
			result += money;
		}
		
		System.out.println(result);
	}
}
