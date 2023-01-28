package programmers;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
    //[2, 3, 3, 5]  -> [3, 5, 5, -1]
    //[9, 1, 5, 3, 6, 2] -> [-1, 5, 6, 6, -1, -1]
    //길이 100만 -> log 사용.

    public static int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            //하강직선

            if(stack.isEmpty()) { //처음 숫자는 무조건 넣고 시작.
                stack.push(i);
            }else if(numbers[i-1] > numbers[i]) { //뒤에 숫자가 작으면 그냥 스택에 넣자.
                stack.push(i);
            } else { //뒤에 숫자가 커졌을 때
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,5,3,6,2,8,6,8,5,6})));
//        System.out.println(Arrays.toString(solution(new int[]{9,1,5,3,6,2})));
//        System.out.println(Arrays.toString(solution(new int[]{2,3,3,5})));
    }
}
