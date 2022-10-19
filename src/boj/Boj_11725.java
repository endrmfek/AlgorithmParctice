package boj;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj_11725 {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		visited = new boolean[n+1];
		answer = new int[n+1];
		for(int i=0; i<=n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0 ; i<n-1; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		dfs(1);
		for(int i=2; i<=n; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		for(int next : tree.get(start)) {
			if(!visited[next]) {// 안가봤으면
				answer[next] = start;
				dfs(next);
			}
		}
	}
}
