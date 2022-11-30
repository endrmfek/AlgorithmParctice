import java.util.*;
class Solution {
    
    public List solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        if (k > score.length) {
            for(int i=0; i< score.length; i++) {
                data.add(score[i]);
                data.sort(Collections.reverseOrder());
                answer.add(data.get(data.size() - 1));
            }
        }else {
            for(int i=0; i<k; i++) {
                data.add(score[i]);
                data.sort(Collections.reverseOrder());
                answer.add(data.get(data.size() - 1));
            }
            for(int i=k; i<score.length; i++) {
                data.add(score[i]);
                data.sort(Collections.reverseOrder());
                answer.add(data.get(k-1));
            }
        }
        
        return answer;
    }
}