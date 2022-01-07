package gridy;

import java.util.ArrayList;
import java.util.Scanner;

//조합?
//모든 경우의수 그냥 구하면 될듯.

public class ChooseBall {
	
	public static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ArrayList<Integer> data = new ArrayList<>();
		
		
		for(int i=0; i<n; i++ ) {
			data.add(sc.nextInt());
		}
		
		int result = 0;
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				if (data.get(min) != data.get(j)) {
					result +=1;
				}
			}
		}
		
		System.out.println(result);
		
//		int[] arr = new int[11];
//		n = sc.nextInt();
//		m = sc.nextInt();
//		
//		for(int i=0; i<n; i++) {
//			int x = sc.nextInt();
//			arr[x] += 1;
//		}
//		
//		int result =0;
//		
//		for(int i=1; i<=m; i++) {
//			n -= arr[i];
//			result += arr[i]*n;
//		}
//		
//		System.out.println(result);
	}
}
