import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int k, int m, int[] score) {
        //1 ~ k 점.
        //한 상자에 사과를 m개씩.
        //가장 낮은 점수가 p일때 -> 가격이 p*m.
        //k = 3 , m = 4 사과 7개 점수가
        //최저 사과 점수 x 한 상자에 담긴 사과 개수 x 상자의 개수
        int answer = 0;
        int box = score.length / m;
        int[][] apple = new int[box][m];
        score = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        
        for(int i=0; i<box; i++) {
            for(int j=0; j<m; j++) {
                apple[i][j] = score[(i*m)+j];
            }
            answer += (apple[i][m-1] * m);
         
        }


        return answer;
    }
}