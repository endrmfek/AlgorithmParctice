package programmers.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 햄버거만들기 {


    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<ingredient.length; i++) {
            stack.add(ingredient[i]);

            if(stack.size() >= 4) {
                int stackSize = stack.size();
                if (stack.get(stackSize-1) == 1
                    && stack.get(stackSize-2) == 3
                    && stack.get(stackSize-3) == 2
                    && stack.get(stackSize-4) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                };

            }
        }
        return answer;
    }

    public int solution2(int[] ingredient) {
        int answer = 0;
        //순서대로 상수의 앞에 아래서
        //아래서부터 빵 야채 고기 빵
        //1 = 빵 , 2 = 야채 = 3 고기
        String data = Arrays.toString(ingredient).replaceAll("[^0-9]" , "");

        while(true) {
            if(!data.contains("1231")) break;
            else {
                answer++;
                data = data.replaceFirst("1231" , "");
            }
        }
        int index = 0;

        return answer;
    }


    public static void main(String[] args) {
        햄버거만들기 a = new 햄버거만들기();
        System.out.println(a.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
}
