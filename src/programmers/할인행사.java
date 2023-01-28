package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 할인행사 {

        //매일 한가지 제품 할인 -> 하루에 하나씩만 구매.
        //10일 연속으로 일치할경우
        //개쉽져? 이거 어떻게할거야??
        //dfs?

        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            Map<String, Integer> bucket = new HashMap<>();

            for(int i=0; i<want.length; i++) {
                bucket.put(want[i], number[i]);
            }

            int count = IntStream.of(number).sum();

            for(int i=0; i<discount.length-count+1; i++) {
                Map<String, Integer> temp = new HashMap<>();

                for(int j=i; j<i+count; j++) {
                    if(!bucket.containsKey(discount[j])) break;
                    temp.put(discount[j], temp.getOrDefault(discount[j], 0) + 1);
                }

                if(bucket.equals(temp)) {
                    answer++;
                }
            }
            return answer;
    }

    public static void main(String[] args) {
        할인행사 a = new 할인행사();
        a.solution(new String[] {"banana", "apple", "rice", "pork", "pot"}, new int[] {3,2,2,2,1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});

    }
}
