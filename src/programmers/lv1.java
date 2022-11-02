package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class lv1 {

    //n의 약수?
    public int solution2(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if (n%i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    //오름차순으로.
    public List<Integer> solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }
        return result.stream().distinct().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        lv1 a = new lv1();
        System.out.println(a.solution(new int[] {2,1,3,4,1}));
    }
}
