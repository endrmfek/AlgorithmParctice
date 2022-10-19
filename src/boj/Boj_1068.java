package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1068 {
	
	
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	static int deleteNode = 0;
	static int answer = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int root = 0;
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i=0; i<n; i++) {
			int p = sc.nextInt(); // -1 0 0 2 2 4 4 6 6
			if(p != -1) {
				tree.get(i).add(p);
				tree.get(p).add(i);
			} else {
				root = i;
			}
		}
		
		deleteNode = sc.nextInt();
		if(deleteNode == root) {
			System.out.println(0);
		} else {
			dfs(root);
			System.out.println(answer);
		}
		
	}
	
	static void dfs(int start) {
		visited[start] = true;
		int cNode = 0; // 자식노드
		for(int next : tree.get(start)) {
			if (!visited[next] && next != deleteNode) {
				cNode++;
				dfs(next);
			}
		}
		if(cNode == 0) { // 자식노드가 없으면
			answer++;
		}
		
	}
}
