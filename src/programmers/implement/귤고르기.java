package programmers.implement;

import java.util.*;

public class 귤고르기 {
    //서로다른 종류의 수를 최소화하고싶은데
    //이거 그 파이썬의 카운터로하면 진짜 개쉽게 풀수있거든여?
    //k까면서 하면돼 오케? 레츠고
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer , Integer> map = new HashMap<>();

        //각각 개수새 -> 최대 10만
        for(int num : tangerine) {
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> counter = new ArrayList<>(map.entrySet());
        counter.sort((a,b)-> b.getValue() - a.getValue());

        for(int i=0; i<counter.size(); i++) {
            answer++;
            k = k - counter.get(i).getValue();
            if(k <= 0) break;
        }

        return answer;
    }

}
