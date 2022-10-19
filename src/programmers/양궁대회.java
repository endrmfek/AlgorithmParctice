package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 양궁대회 {
	//라이언 vs 어피치
    //어피치 선공 -> 라이언 후궁
    //k (점수)를 어피치가 a발 라이언 b발일때 더 많은 화살을 k점에. a=b 면 어피치 승
    //여러발 맞춰도 k만 가져감. ,
    //화살 n발
    // 라이언이 큰점수차로 이겨야돼
    // 어피치쏜 점수 info
    // 10 -> 0 순으로 정수배열에 담어.
	static ArrayList<int[]> answerList = new ArrayList<>();
	static int max_diff = -1;
	static int[] ryan;
	static int[] apeach;
	
    public int[] solution(int n, int[] info) {
        //실 패 했 다.
    	//dfs로 모든 경우의 수 구해야된다는 아이디어 조차 안떠올랐음.
    	//더 연습하자.
    	int[] answer = {};
    	ryan = new int[11];
    	apeach = info.clone();
    	
    	//n , depth, start;
    	dfs(n,0,0);
    	
    	if(max_diff == -1) {
    		return new int[] {-1};
    	}
    	//answerList 에서 정답 찾기.
    	/*
    	answerList.sort(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			for(int i=10; i<=0; i++) {
    				if(o1[i] != o2[i]) {
    					return o2[i] - o1[i];
    				}
    			}
    			return 0;
    		}
		});
    	*/
    	Collections.sort(answerList, (a,b) -> {
    		for(int i=10; i>=0; i--) {
    			if (a[i] != b[i]) {
    				return b[i]-a[i];
    			}
    		}
    		return 0;
    	});
    	
    	return answerList.get(0);
    }
    
    static void dfs(int n, int depth, int start) {
    	if (depth == n) {
    		int apeach_sum = 0;
    		int ryan_sum = 0;
    		for(int i=0; i<10; i++) { // 0점은 필요없으니까?
    			int score = 10-i;
    			if(apeach[i] == 0 && ryan[i] == 0) continue;
    			if(apeach[i] >= ryan[i]) apeach_sum += score;
    			else ryan_sum += score;
    		}
    		
    		if(ryan_sum > apeach_sum) {
    			int diff = ryan_sum - apeach_sum;
    			if(diff > max_diff) {
    				max_diff = diff;
    				answerList.clear();
    				answerList.add(ryan.clone());
    			} else if(diff == max_diff) {
    				answerList.add(ryan.clone());
    			}
    		}
    		
    		return;
    	}
    	
    	for(int i=start; i<11; i++) {
    		ryan[i]++;
    		dfs(n, depth+1, i);
    		ryan[i]--;
    	}
    }  
}
