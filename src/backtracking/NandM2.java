package backtracking;

import java.util.Scanner;

public class NandM2 {
	public static int[] arr;
	public static int n,m;
	public static boolean[] visit;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		visit = new boolean[n+1];
//		nAndm(0, 0);
		dfs(0);
	}

	// depth는 자리수
	// index부터 돌려서 순서를
	private static void nAndm(int idx, int depth) {
		if(depth == m) {
			for(int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx; i<n; i++) {
			arr[depth] = i+1;
			nAndm(i+1, depth+1);
		}
	}
	
	private static void dfs(int depth) {
		if(m == depth) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visit[i]) {
				if(depth==0 || arr[depth-1] < i) {
					visit[i] = true;
					
					arr[depth] = i;
					
					dfs(depth+1);
					
					visit[i] = false;
				}
			}
		}
	}
}
