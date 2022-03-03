package shortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다익스트라. 최단거리 테이블 필수. graph 필수.

class Node_m implements Comparable<Node_m>{
	private int x;
	private int y;
	private int distance;
	
	public Node_m(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getDistance() {
		return this.distance;
	} 
	
	@Override
	public int compareTo(Node_m other) {
		// TODO Auto-generated method stub
		return this.distance - other.distance;
	}
	
	
	
}

public class MarsExplorer {
	//출발 지점에서 목표 지점까지 이동할 때 최적의 경로. -> 다익스트라
	//n*n 2차원 [0][0] -> [n-1][n-1]
	public static final int INF = (int)1e9; 
	public static int n;
	public static int[][] graph = new int[125][125];
	public static int[][] d = new int[125][125];
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int tc=0; tc<test; tc++) {
			n = sc.nextInt();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<n; i++) {
				Arrays.fill(d[i], INF);
			}
			
			int x =0 , y = 0; // 시작
			PriorityQueue<Node_m> pq = new PriorityQueue<Node_m>();
			pq.offer(new Node_m(0, 0, 0));
			d[x][y] = graph[x][x];
			
			while(!pq.isEmpty()) {
				Node_m node = pq.poll();
				int dist = node.getDistance();
				x = node.getX();
				y = node.getY();
				
				if(d[x][y] <dist) continue; //이미 처리된 경우 처리 x
				
				for(int i=0; i<n; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || nx >= n || ny <0 || ny >=n) continue;
					
					int cost = dist + graph[nx][ny];
					if(cost < d[x][y]) { //거쳐가는게 더 짧으면
						d[x][y] = cost;
						pq.offer(new Node_m(nx, ny, cost));
					}
				}
			}
			
			System.out.println(d[n-1][y-1]);
		}
	}
}
