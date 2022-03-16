package dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Virus_2606 {
	static int n,m;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] checked = new boolean[101];
	static int count =0;
	
	public static int dfs(int start) {
		
		checked[start] = true;
		
		for(int i=0; i<graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);
			if(!checked[y]) {
				count++;
				dfs(y);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		System.out.println(dfs(1));
	}
}
