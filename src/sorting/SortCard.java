package sorting;

import java.util.PriorityQueue;
import java.util.Scanner;


public class SortCard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int result =0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			pq.offer(sc.nextInt());
		}
		
		while(pq.size() != 1) {
			int first = pq.poll();
			int second = pq.poll();
			
			int sum = first + second;
			result += sum;
			pq.offer(sum);
		}
		
		System.out.println(result);
		
	}
}
