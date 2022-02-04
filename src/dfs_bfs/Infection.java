package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Virus implements Comparable<Virus>{
	private int index;
	private int time;
	private int x;
	private int y;
	
	public Virus(int index, int time, int x, int y) {
		this.index = index;
		this.time = time;
		this.x = x;
		this.y = y;
	}
	
	public int getIndex() {
		return index;
	}
	public int getTime() {
		return time;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public int compareTo(Virus other) {
		return this.index - other.index;
	}
	
}

public class Infection {
	public static int n,k,s,x,y;
	public static int[][] graph = new int[200][200];
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static ArrayList<Virus> viruses = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //크기
		k = sc.nextInt(); //바이러스 개수
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				graph[i][j] = sc.nextInt();
				if(graph[i][j] != 0) {
					viruses.add(new Virus(graph[i][j], 0, i, j));
				}
			}
		}
		
		Collections.sort(viruses); //index 1부터.
		Queue<Virus> q = new LinkedList<>();
		for(int i=0; i<viruses.size(); i++) {
			q.offer(viruses.get(i));
		}
		
		int targetS = sc.nextInt();
		int targetX = sc.nextInt();
		int targetY = sc.nextInt();
		
		
		//이제 bfs가야지.
		
		while(!q.isEmpty()) { // targetS가 같아질때 종료해야돼.
			Virus virus = q.poll();
			
			if (virus.getTime() == targetS) break;
			
			for(int i=0; i<4; i++) { // 4가지 방향 돌면서
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				if(0<=nx && nx <n && 0<=ny && ny<n) {
					if(graph[nx][ny]== 0) {
						graph[nx][ny] = virus.getIndex();
						q.offer(new Virus(virus.getIndex(), virus.getTime()+1, nx, ny));
					}
				}
			}
		}
		
		System.out.println(graph[targetX - 1][targetY - 1]);
	}
}
