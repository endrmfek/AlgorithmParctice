import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> bro = new HashSet<>();
        Map<Integer, Integer> littleBro = new HashMap<>();
        for(int top : topping) {
            littleBro.put(top, littleBro.getOrDefault(top, 0) + 1);
        }

        for(int top : topping) {
            littleBro.computeIfPresent(top, (key, value) -> value-1);
            bro.add(top);

            if(littleBro.get(top) == 0) {
                littleBro.remove(top);
            }

            if(bro.size() == littleBro.size()) {
                answer++;
            }
        }

        return answer;
    }
}