package programmers;

import java.util.*;

public class 숫자게임 {
    public int solutionGood(int[] A , int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
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

        for(int i=0; i<A.length; i++) {
            if(qA.getLast() >= qB.getFirst()) {
                int a= qA.pollLast(); // 제일 큰거
                int b =qB.pollLast(); //제일 작은거
                System.out.println("qA = " + a + "qB = " + b);
            } else {
                qA.pollLast();
                qB.pollFirst();
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
