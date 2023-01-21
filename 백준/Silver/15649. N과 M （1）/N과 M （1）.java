import java.util.Scanner;

public class Main {
	
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
		if(m == depth) {
			for(int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) { //방문하지 않았다면
				visit[i] = true;
				arr[depth] =i+1;
				nAndm(n, m, depth + 1);
				visit[i] = false;
			}
		}
	}
}