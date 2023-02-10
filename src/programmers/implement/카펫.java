package programmers.implement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 카펫 {


    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Integer> divisor = divisor(yellow);

        for(Integer row : divisor) {
            int n = row + 2;
            int m = (int) (yellow / row) + 2;

            if(n < m) continue;

            if((n*m) == (brown + yellow)) {
                answer[0] = n;
                answer[1] = m;
            }
        }
        return answer;
    }

    private List<Integer> divisor(int number) {
        List<Integer> divisor = new ArrayList<>();
        int n = (int) Math.sqrt(number);

        for(int i=1; i<n+1; i++) {
            if(number % i == 0) {
                divisor.add(i);
                if(number / i != i) {
                    divisor.add(number/i);
                }
            }
        }

        divisor.sort(Comparator.naturalOrder());
        return divisor;
    }
}
