package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        //n은 자연수 개수 , s는 target sum
        int[] answer = new int[n];
        if (n>s) {
            return new int[]{-1};
        }
        int share = s/n;
        int remainder = s%n;

        for(int i=0; i<n; i++) {
            answer[i] = share;
        }

        for(int i=0; i<remainder; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
        return answer;
    }


    public static void main(String[] args) {
        최고의집합 a = new 최고의집합();
        a.solution(3,14);

    }

}
