package programmers;

import java.util.*;

public class 숫자게임 {
    public int solutionGood(int[] A , int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        //가장 큰거부터 A만 소비해.
        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            //B가 이기는 경우
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
            //지면 B는 그대로 A만 소비.
        }
        return answer;
    }


    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        Deque<Integer> qA = new LinkedList<>();
        Deque<Integer> qB = new LinkedList<>();

        for(int i=0; i<A.length; i++) {
            qA.addLast(A[i]); // 1,2,3,4,5
            qB.addFirst(B[i]); //5,4,3,2,1
        }
//        qA.forEach(i -> System.out.print(i + " "));
//        qB.forEach(i -> System.out.print(i + " "));

        for(int i=0; i<A.length; i++) {
            if(qA.getLast() >= qB.getFirst()) { //가장 큰거끼리 비교하고 qA가 더 크면 -> qB의 제일 작은걸 소비해.
                int a= qA.pollLast(); // 제일 큰거
                int b =qB.pollLast(); //제일 작은거
                System.out.println("qA = " + a + "qB = " + b);
            } else {
                qA.pollLast(); //큰거
                qB.pollFirst(); //큰거거
               answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        숫자게임 a = new 숫자게임();
        a.solution(new int[] {5, 1, 3, 7} , new int[] { 2, 2, 6, 8});
    }
}
