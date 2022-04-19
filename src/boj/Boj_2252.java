package boj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2252 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] indegree = new int[n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b); // 초기화
			
			indegree[b]++;	//위상정렬. 진입차수 올리기
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll(); //진입차수가 0을 뺀거
			System.out.print(now + " ");
			for(Integer next : graph.get(now)) { // 다음 노드의 진입차수를 내려
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
