package programmers.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 큰수만들기 {

    public String solution(String number, int k) {

        int size = number.length() -k;

        char[] input = number.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length; i++) {
            //4177252841
            while(!stack.empty() && k>0 && stack.peek() < input[i]) {
                k--;
                stack.pop();
            }

            stack.push(input[i]);

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            sb.append(stack.get(i));
        }


        return sb.toString();
    }



    /**
     * 시간초과
     * */
    static List<String> data = new ArrayList<>();

    public static String solution2(String number, int k) {
        char[] num = number.toCharArray();
        List<Integer> index = new ArrayList<>();
        dfs(0, 0, num, index, k);
        data.sort((o1,o2)-> Integer.parseInt(o2) - Integer.parseInt(o1));

        return data.get(0);
    }

    private static void dfs(int depth, int next, char[] num, List<Integer> index, int k) {
        if(depth == num.length-k) {
            StringBuilder sb = new StringBuilder();
            for(int i : index) {
                sb.append(num[i]);
            }
            data.add(sb.toString());
            return;
        }

        for(int i=next; i<num.length; i++) {
            index.add(i);
            dfs(depth+1, i+1, num, index, k);
            index.remove(index.size()-1);
        }

    }

    public static void main(String[] args) {
        solution2("1924", 2);
    }
}
