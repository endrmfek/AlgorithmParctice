package backtracking;

import java.util.Scanner;

public class NandM4 {
	public static int n,m;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();	
		
		arr = new int[m];
		visit = new boolean[n+1];
		
		nAndm(0, 1);
		System.out.println(sb);
	}

	//중복조합? -> 4C2 -> 11,12,13,14 / 22,23,24 / 33,34 / 44
	private static void nAndm(int depth, int idx) {
		if(depth == m) {
			for(int a : arr) {
				sb.append(a + " ");
			}
			sb.append('\n');
			return;
		}

		for(int i=idx; i<=n; i++) {
			arr[depth] = i;
			nAndm(depth+1 , i);
		}
	}
	
}
