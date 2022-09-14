package programmers;

public class 순위 {
	
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] graph = new boolean[n+1][n+1];
        
        for (int i=0; i<results.length; i++) {
        	graph[results[i][0]][results[i][1]] = true;
        }
        
        for (int k=1; k<n+1; k++) {
        	for (int i=1; i<n+1; i++) {
        		for (int j=1; j<n+1; j++) {
        			if( i != j && graph[i][k] && graph[k][j]) {
        				graph[i][j] = true;
        			}
        		}
        	}
        }
        
        for(int i=1; i<n+1; i++) {
        	boolean pass = true;
        	for(int j=1; j<n+1; j++) {
        		if (i != j && !(graph[i][j] || graph[j][i])) {
        			pass = false;
        			break;
        		}
        	}
        	if(pass) {
        		answer ++;
        	}
        }
        		
        		
        return answer;
    }
	
}
