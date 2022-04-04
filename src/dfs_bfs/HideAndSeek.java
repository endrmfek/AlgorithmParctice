package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {
	public static int N,K;
	public static int[] visited = new int[100001];
	
	public static Queue<Integer> q = new LinkedList<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(N==K) {
			System.out.println(0);
			return;
		}
		
		System.out.println(bfs(N));

	}
	
	public static int bfs(int n) {
		visited[n] = 1;
		q.offer(n);
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			
			int before = now-1;
			int after = now +1;
			int multi = 2*now;
			
			if(now == K) {
				return visited[now]-1;
			}
			
			if( before >= 0 && visited[before] == 0 ) {
				visited[before] = visited[now] + 1;
				q.offer(before);
			}
			if( after <100001 && visited[after] == 0 ) {
				visited[after] = visited[now] + 1;
				q.offer(after);
			}
			if( multi <100001 && visited[multi] == 0 ) {
				visited[multi] = visited[now] + 1;
				q.offer(multi);
			}
			
		}
		
		return -1;
	}
}
