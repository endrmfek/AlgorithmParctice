import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Integer[] a = new Integer[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		int max = a[n-1];
		float result = 0;
		for(int i=0; i<n; i++) {
			result += a[i];
		}
		
		System.out.println( result * 100 / max / n);
	}
}
