package dynamic;

import java.util.Scanner;

public class AntWarrior {
	public static int[] d = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[n] = sc.nextInt();
		}
		
		d[0] = arr[0];
		d[1] = arr[1];
		
		for(int i=2; i<n; i++) { //맨 마지막을 먹으냐 안먹느냐 싸움.
			d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
		}
		
		System.out.println(d[n-1]);
	}
	
	
}
