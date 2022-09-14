package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n+1];
        
        Arrays.fill(distance, -1);
        
        for (int i=0; i<=n; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<edge.length; i++) {
        	int start = edge[i][0];
        	int end = edge[i][1];
        	
        	graph.get(start).add(end);
        	graph.get(end).add(start);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        distance[1] = 0;
        
        while (!q.isEmpty()) {
        	int startIndex = q.poll();
        	
        	for(int nextIndex : graph.get(startIndex)) {
        		if (distance[nextIndex] == -1) {
        			q.add(nextIndex);
        			distance[nextIndex] = distance[startIndex] + 1;
        		}
        	}
        }
        
        int max = Arrays.stream(distance).max().getAsInt();
        answer = (int) Arrays.stream(distance).filter(x -> x == max).count();
        for (int i : distance) {
        	if (i == max) {
        		answer += 1;
        	}
        }
        
        return answer;
    }
}
