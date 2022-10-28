package programmers;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열의합의개수 {

        //3 ≤ elements의 길이 ≤ 1,000
        //1 ≤ elements의 원소 ≤ 1,000
        //[7,9,1,1,4]
        public int solution(int[] elements) {
            int answer = 0;
            int[] temp = new int[elements.length * 2];
            Set<Integer> result = new HashSet<>();

            for(int i=0; i<elements.length; i++) {
                temp[i] = elements[i];
                temp[i+elements.length] = elements[i];
            }

            for(int i=1; i<=elements.length; i++) { //크기 1~5
                System.out.print(i + " =" + " ");
                for(int j=0; j<elements.length; j++) { //인덱스
                    int sum = 0;
                    for(int k=j; k<j+i; k++) {
                        sum += temp[k];
                    }
                    System.out.print(sum + " ");
                    result.add(sum);
                }
                System.out.println();
            }
            return result.size();

        }

    public static void main(String[] args) {
        연속부분수열의합의개수 a = new 연속부분수열의합의개수();
        System.out.println(a.solution(new int[] {7,9,1,1,4}));
    }
}
