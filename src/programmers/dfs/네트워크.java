package programmers.dfs;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {
    boolean[] visited;
    List<List<Integer>> graph;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        graph = new ArrayList<>();
        for(int i=0; i<computers.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(i == j) continue;

                if(computers[i][j] != 0) {
                    graph.get(i).add(j);
                }
            }
        }

        //단순 탐색.
        for(int i=0; i<computers.length; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
         return answer;
    }

    void dfs(int start) {
        visited[start] = true;
        for(Integer next : graph.get(start)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
