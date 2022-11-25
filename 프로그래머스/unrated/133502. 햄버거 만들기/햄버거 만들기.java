import java.util.*;
class Solution {
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
}