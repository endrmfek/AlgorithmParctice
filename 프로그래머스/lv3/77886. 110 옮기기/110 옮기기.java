import java.util.*;

class Solution {
    //110을 뽑아야되잖아. -> 110을 빼.
    //모든 자리에 110을 넣고 비교해?
    //0이 무조건 앞으로와야돼. -> 처음 0을 찾고 110을 바로 삽입.
    public List solution(String[] s) {
        List<String> answer = new ArrayList<>();
        for(String data : s) {
            //모든 110을 빼내야되는데 이거 어떻게 할거야? -> 스택.
            Stack<Character> stack = new Stack<>();
            int cnt110 = 0;
            char[] chars = data.toCharArray();

            //'110' 개수세기.
            for(int i=0; i<chars.length; i++) {
                char z = chars[i];

                if(stack.size() > 1) { //stack에 원소가 2개이상이라면
                    char y = stack.pop();
                    char x = stack.pop();

                    if(x == '1'&& y == '1' && z == '0') {
                        cnt110++;
                    } else {
                        stack.add(x);
                        stack.add(y);
                        stack.add(z);
                    }
                } else {
                    stack.add(z);
                }
            }

            //마지막 0 찾아야돼.
            int index = stack.size();
            boolean flag = false;
            StringBuilder sb = new StringBuilder();

            while(!stack.isEmpty()) {
                char c = stack.pop();
                if(!flag) {
                    if(c == '1') {
                        index--;
                    } else {
                        flag = true;
                    }
                }

                sb.insert(0, c);
            }

            if(cnt110 > 0) {
                while(cnt110-- > 0) {
                    sb.insert(index ,"110");
                    index += 3;
                }
                answer.add(sb.toString());
            } else {
                answer.add(data);
            }
        }
        return answer;
    }
}