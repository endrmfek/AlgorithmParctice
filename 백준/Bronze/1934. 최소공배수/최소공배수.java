
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int g = gcd(x, y);
			
			System.out.println((x*y)/g);
		}
		
	}
	
	private static int gcd(int a, int b) {
		
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
		
		
 	}
}
