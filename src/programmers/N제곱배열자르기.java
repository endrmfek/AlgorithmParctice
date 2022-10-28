package programmers;

import java.util.ArrayList;
import java.util.List;

public class N제곱배열자르기 {
	public int[] solution(int n, long left, long right) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        
        //1행 1열부터 i행i열까지 영역내의 모든 빈칸을 어떻게 채울꺼야?.. -> 여기서 오류. n의 범위가 너무큼.
        
        //공식이 있습니까?..
        List<Long> list = new ArrayList<>();
        for(long i=left; i<=right; i++) {
        	list.add(Math.max(i/n, i%n));
        }
        
        return answer;
    }

}
