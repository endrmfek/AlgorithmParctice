package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 피로도 {
	static boolean[] visited;
	static int answer;
	public static int solution(int k, int[][] dungeons) {
        // 최대한 많이.
		// [최소필요피로도 , 소요피로도]
		// [[80,20],[50,40],[30,10]]
		answer =0;
		visited = new boolean[dungeons.length];
        Arrays.sort(dungeons, Comparator.comparing(a -> -a[0]));
        
        dfs(0, k,  dungeons);
        
        return answer;
    }
	
	static void dfs(int depth, int total, int[][] dunge) {
		for (int i=0; i<visited.length; i++) {
			if (visited[i] == false && total >= dunge[i][0]) {
				visited[i] = true;
				dfs(depth+1, total-dunge[i][1] , dunge);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, depth);
	}
	
	public static void main(String[] args) {
		solution(80 , new int[][] {{80,20},{50,40},{30,10}});
	}
}
