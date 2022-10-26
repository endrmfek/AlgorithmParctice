import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
class Solution {
    //매일 한가지 제품 할인 -> 하루에 하나씩만 구매.
        //10일 연속으로 일치할경우
        //개쉽져? 이거 어떻게할거야??
        //dfs?

        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            //Map으로 해결하고 싶지?
            //완전탐색으로 풀 수 있지만, 다른방법을 생각해보자.
            Map<String, Integer> bucket = new HashMap<>();

            for(int i=0; i<want.length; i++) {
                bucket.put(want[i], number[i]);
            }
            // System.out.println(bucket.toString());
            int count = IntStream.of(number).sum();

            for(int i=0; i<discount.length-count+1; i++) {
                Map<String, Integer> temp = new HashMap<>();
                for(int j=i; j<i+count; j++) {
//                    System.out.print(j + " ");
                    if(!bucket.containsKey(discount[j])) break;
                    temp.put(discount[j], temp.getOrDefault(discount[j], 0) + 1);
                }
                // System.out.println(i + " " + temp.toString());
//                System.out.println();

                if(bucket.equals(temp)) {
                    answer++;
                }
            }
            return answer;
    }
}