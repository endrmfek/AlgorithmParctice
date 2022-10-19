package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_14425 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		Set<String> dict = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			dict.add(sc.next());
		}
		
		for(int i=0; i<m; i++) {
			String data = sc.next();
			if (dict.contains(data)) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}	


