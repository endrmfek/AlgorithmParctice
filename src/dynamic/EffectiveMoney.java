package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class EffectiveMoney {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] money = new int[n];
		for(int i=0; i<n; i++) {
			money[i] = sc.nextInt();
		}
		
		int[] d = new int[m+1]; // 0~m까지.
		Arrays.fill(d, 10001);
		
		d[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=money[i]; j<m+1; j++) {
				d[j] = Math.min(d[j], d[j-money[i]] + 1); 
			}
		}
		
		if(d[m] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(d[m]);
		}
		
				
	}
}
