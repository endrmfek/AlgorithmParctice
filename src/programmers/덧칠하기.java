package programmers;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int next = 0;
        for(int i=0; i<section.length; i++) {
            //칠하고
            answer++;
            //옮기고
            next = section[i] + m ;

            while(i+1 < section.length && next > section[i+1]) {
                i++;
            }

        }

        return answer;
    }

}
