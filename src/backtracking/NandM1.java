package backtracking;

import java.util.Scanner;

public class NandM1 {
	//n과 m이 주어질때 아래 조건을 만족하는 길이가 m인 수열을 모두구해.
	//중복 x.
	
	public static int[] arr;
	public static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[m];
		visit = new boolean[n];
		
		nAndm(n,m,0);
	}
	
	private static void nAndm(int n, int m, int depth) {
		if (m == depth) {
			for(int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				nAndm(n, m, depth+1);
				visit[i] = false;
			}
		}
			
	}
}
