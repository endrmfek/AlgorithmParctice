import java.util.Scanner;

public class Main {
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
	
	private static void nAndm(int depth, int idx) {
		if(depth == m) {
			for(int a : arr) {
				sb.append(a + " ");
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i=1; i<=n; i++) {
			
			if(idx <= i) {
				arr[depth] = i;
				nAndm(depth+1 , i);
			}
		}
	}
	
}
