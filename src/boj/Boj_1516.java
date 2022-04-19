package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1516 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] indegree = new int[n+1]; // 진입차수
		int[] selfBuild = new int[n+1]; // 자기 자신을 만드는데 걸리는 시간
		
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int preTemp = Integer.parseInt(st.nextToken());
				if(preTemp == -1) {
					break;
				}
				graph.get(preTemp).add(i); //pretemp가 미리 지어져야되는 노드. (pretemp -> i를 가리키고있는 상태)
				indegree[i]++; // 진입차수를 올려준다.
			}
		}
		
		//알고리즘 시작(위상정렬) 
		int[] result = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(Integer next : graph.get(now)) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[now] + selfBuild[now]);
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.println(result[i] + selfBuild[i]);
		}
	}
}
