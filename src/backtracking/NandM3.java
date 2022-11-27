package backtracking;

import java.util.Scanner;

public class NandM3 {
	public static int n,m;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		
		nAndm(0);
		System.out.println(sb);
	}

	//중복없는 순열 4p2 -> 1111 , 1112 , 1113
	private static void nAndm(int depth) {
		if(depth == m) {
			for(int a : arr) {
				sb.append(a + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[depth] = i+1;
			nAndm(depth+1);
		}
	}
}
