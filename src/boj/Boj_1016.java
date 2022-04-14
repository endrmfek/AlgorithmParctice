package boj;

import java.lang.System.Logger;
import java.util.Scanner;

public class Boj_1016 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		
		boolean[] checked = new boolean[ (int)(max-min)+1];
		
		for(long i=2; i*i <=max; i++) {
			long pow = i*i; // 제곱수
			long start = (min%pow == 0) ? min/pow : min/pow + 1; // 시작*pow >= min 이여야됨. -> 이건 인덱스 개념이 아님..
			for(long j= start; j*pow <= max; j++) {
				System.out.println("pow : " + pow +" start : " + start + " , index = " + (int) ((j*pow) - min));
				checked[(int) ((j*pow) - min)] = true;
				//min을 빼주는 이유는 min이 1이면 인덱스 0 = 1
				//min이 5면 인덱스 0 = 5; 인덱스 1 = 6 -> min값을 빼줘야 인덱스 값을 구할 수 있음.
			}
		}
		System.out.println();
		
		int count = 0;
		for(int i=0; i<= max-min; i++) {
			if(!checked[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
}
