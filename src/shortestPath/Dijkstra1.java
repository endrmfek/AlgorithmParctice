package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class node_d1 {
	private int index;
	private int distance;
	
	public node_d1(int index , int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
}

public class Dijkstra1 {
	public static final int INF = (int) 1e9;
	
	//노드의 개수n. 간선의 개수m. 시작번호 start
	public static int n,m,start;
	
	//각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<node_d1>> graph = new ArrayList<>();
	
	//방문한 적이 있는지 체크하는 목적의 배열 만들기
	public static boolean[] visited = new boolean[100001];
	
	//최단거리 테이블
	public static int[] d = new int[100001];
	
	public static int getShortestNode() {
		int min_value = INF;
		int index = 0;
		for(int i=1; i<=n; i++) {
			if(d[i] < min_value && !visited[i]) {
				min_value = d[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		d[start] = 0;
		visited[start]= true;
		
		for(int j=0; j<graph.get(start).size(); j++) {
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance(); // 거리초기화
		}
		
		//시작노드를 제외한 노드에 대해 반복.
		
		for(int i=0; i<n-1; i++) {
			int now = getShortestNode();
			visited[now] = true;
			
			//현재 노드와 연결된 친구들 확인
			for(int j=0; j<graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				if(cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new node_d1(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		// 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
	}
}
