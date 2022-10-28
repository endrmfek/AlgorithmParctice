package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 롤케이크자르기 {

    //2조각 -> 1조각씩.
    //방법의 수? -> 잘라놓고 생각해
    //100만 ? logn으로 해결
    //이거 파이썬이면 슬라이싱으로 존나쉽게 풀수있는데 ㅠㅠ
    public int solution1(int[] topping) {
        int answer = 0;
        //topping lenght가 8이라면
        //[1,2,1,3,1,4,1,2] 마지막 인덱스가 7.
        List<Integer> toppings = IntStream.of(topping).boxed().collect(Collectors.toList());
        for(int i=1; i<topping.length; i++) {
            long bro = toppings.subList(0,i).stream().distinct().count();
            long littleBro = toppings.subList(i,topping.length).stream().distinct().count();
            if(bro == littleBro) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int[] topping) {
        int answer = 0;
        //topping lenght가 8이라면
        //[1,2,1,3,1,4,1,2] 마지막 인덱스가 7.
        List<Integer> toppings = IntStream.of(topping).boxed().collect(Collectors.toList());
        Set<Integer> bro = new HashSet<>();
        int i=0;
        while(toppings.size() != 1) {
            int number = toppings.remove(0);
            bro.add(number);
            Set<Integer> littleBro = new HashSet<>(toppings);

            if(bro.size() == littleBro.size()) {
                answer++;
            }
        }
        return answer;
    }

    public int solution(int[] topping) {
        int answer = -1;
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

    public static void main(String[] args) {
        롤케이크자르기 a = new 롤케이크자르기();
        a.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
    }
}
