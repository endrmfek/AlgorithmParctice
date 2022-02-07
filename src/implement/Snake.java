package implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node_s {
	private int time;
	private char direction;
	
	public Node_s(int time, char direction) {
		this.time = time;
		this.direction = direction;
	}

	public int getTime() {
		return time;
	}

	public char getDirection() {
		return direction;
	}
	
}

class position {
	private int x;
	private int y;
	
	public position(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

public class Snake {
	
	public static int[][] arr = new int[101][101]; //맵정보.
	public static ArrayList<Node_s> info = new ArrayList<>();
	public static int n,l;

	//오른쪽을 보고 있죠 (동 남 서 북)
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};
	
	public static int turn(int direction, char c) {
		if(c=='L') direction = (direction == 0) ? 3 : direction -1; //반시계
		else direction = (direction + 1) % 4; //시계
		return direction;
	}
	
	public static int simulate() {
		int x = 1, y = 1;
		arr[x][y] = 2; // 뱀위치는 2
		int direction = 0;
		int time =0;
		int index = 0; // 다음 회전 정보.
		
		//뱀이 차지하고있는 위치정보.
		Queue<position> q = new LinkedList<>();
		q.offer(new position(x, y));
		
		while(true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			if( 1<= nx && nx<=n && 1<=ny && ny <=n && arr[nx][ny] != 2) { //범위 안, 몸통에 닿지 않는다면
				//사과가 없다면 이동 후에 꼬리 제거
				if(arr[nx][ny] == 0) {
					arr[nx][ny] = 2;
					q.offer(new position(nx, ny));
					position prev = q.poll();
					arr[prev.getX()][prev.getY()] = 0;
				}
				//사과라면 큐에 저장만.
				if(arr[nx][ny] == 1) {
					arr[nx][ny] = 2;
					q.offer(new position(nx, ny));
				}
			}
			else { //쳐부딪혔으면
				time += 1;
				break;
			}
			
			x = nx;
			y = ny;
			time += 1;
			if(index < l && time == info.get(index).getTime()) {
				direction = turn(direction, info.get(index).getDirection());
				index += 1;
			}
			
		}
		return time;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int apple = sc.nextInt();
		
		
		for(int i=0; i<apple; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
		}
		
		l = sc.nextInt();
		for(int i=0; i<l; i++) {
			int x = sc.nextInt();
			char c = sc.next().charAt(0);
			info.add(new Node_s(x,c));
		}
		
		System.out.println(simulate());
	}
}
