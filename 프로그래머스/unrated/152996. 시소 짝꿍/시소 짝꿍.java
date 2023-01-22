import java.util.*;
class Solution {
    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for(int weight : weights) {
            double w = (double) weight;

            //찾고자 하는 비율 있으면
            if(map.containsKey(w)) {
                answer+= map.get(w);
            }
            
            //현재 값으로 만들 수 있는 시소값
            map.put(w , map.getOrDefault(w , 0) + 1); // 같은 거리에 있거나
            map.put(w*3/2 , map.getOrDefault(w*3/2 , 0) + 1); // 2m - 3m
            map.put(w*4/2 , map.getOrDefault(w*4/2 , 0) + 1); //2m -4m
            map.put(w*4/3 , map.getOrDefault(w*4/3 , 0) + 1); //3m -4m
        }

        return answer;
    }


}