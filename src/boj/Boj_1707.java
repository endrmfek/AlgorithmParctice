package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_1707 {
	static ArrayList<ArrayList<Integer>> graph;
	static int RED = 1;
	static int BLUE = -1;
	static int[] colors;
	static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-- >0) {
			check = true;
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			graph = new ArrayList<>();
			colors = new int[v+1];
			for(int i=0; i<v+1; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<e; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.get(a).add(b); // 양뱡향
				graph.get(b).add(a);
			}
			
			for(int i=1; i<=v; i++) {
				if(!check) {
					break;
				}
				
				if(colors[i] == 0) {
					dfs(i, RED);
				}
				
			}
			
			System.out.println(check ? "YES" : "NO");
		}
	}
	

	
	private static void dfs(int start, int color) {
		colors[start] = color;
		
		for(Integer next : graph.get(start)) {
			if(colors[next] == color) {
				check = false;
				return;
			} 
			if (colors[next] == 0){
				dfs(next, -color);
			}
		}
	}
}
