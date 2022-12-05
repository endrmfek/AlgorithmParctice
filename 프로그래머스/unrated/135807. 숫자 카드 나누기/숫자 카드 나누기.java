import java.util.*;
class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int minA = Arrays.stream(arrayA).min().getAsInt();
        int minB = Arrays.stream(arrayB).min().getAsInt();
        Set<Integer> set = new HashSet<>();

        getCommonDivisor(set, minA);
        getCommonDivisor(set, minB);

        List<Integer> commonNumberList = new ArrayList<>(set);

        for(int i=0 ; i<commonNumberList.size(); i++) {
            //철수는 가졌는데 영희는 가지지 않은 경우
            boolean check = true;
            for(int j=0; j<arrayA.length; j++) {
                if(!(arrayA[j] % commonNumberList.get(i) == 0 && arrayB[j] % commonNumberList.get(i) != 0)) {
                    check = false;
                    break;
                }
            }
            if(check) answer = Math.max(answer , commonNumberList.get(i));
            check = true;
            //영희는 가졌는데 철수는 가지지 않은 경우
            for(int j=0; j<arrayB.length; j++) {
                if(!(arrayB[j] % commonNumberList.get(i) == 0 && arrayA[j] % commonNumberList.get(i) != 0)) {
                    check = false;
                    break;
                }
            }
            if(check) answer = Math.max(answer , commonNumberList.get(i));
        }

        return answer;
    }

    void getCommonDivisor(Set<Integer> set, int number) {
        for(int i=2; i<=number; i++) {
            if(number % i == 0) set.add(i);
        }
    }

}