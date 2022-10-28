package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class 택배상자 {
    //한 방향으로만.
    //1~n번.
    //미리 알려준 순서대로
    //보조 컨테이너는 맨 앞의 상자만 -> 선입후출? 스택
    //4 3 1 2 5 ->
    //더이상 실을 수 없을때 종료.
    //영재가 몇개의 상자를 실을 수 있는지 return
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> assist = new Stack<>();
        ArrayList<Integer> container = new ArrayList<>();
        int[] arr = new int[order.length];

        for(int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }
        int arrIndex = 0;
        int orderIndex = 0;
//        [4,3,1,2,5] 1 2 3 stack 4매칭 break; 3 -> 스택뒤져 ㅇㅋ
        //[1,2,3,4,5] 5
        //[5,4,3,2,1]
        //[1,2,3,4,5]
        while(container.size() != order.length && arrIndex != arr.length) {
            if(!assist.isEmpty() && assist.peek() == order[orderIndex]) {
                int number = assist.pop();
                container.add(number);
                orderIndex++;
                continue;
            }
            System.out.println(arrIndex + " " + orderIndex);
            if(arr[arrIndex] == order[orderIndex]) {
                container.add(arr[arrIndex]);
                arrIndex++;
                orderIndex++;

            } else {
                assist.add(arr[arrIndex]);
                arrIndex++;
            }
        }

        while(true) {
            if(!assist.isEmpty() && assist.peek() == order[orderIndex]) {
                int number = assist.pop();
                container.add(number);
                orderIndex++;

            } else {
                break;
            }
        }

        System.out.println(container.toString());
        return container.size();
    }

    public static void main(String[] args) {
        택배상자 a = new 택배상자();
        a.solution(new int[] {4,3,1,2,5});
    }
}
