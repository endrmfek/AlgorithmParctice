package programmers.implement;

public class 마법의엘리베이터 {

    public static int solution(long storey) {
        int answer = 0;
        //자리수 어떻게 구할거야?
        int digit = String.valueOf(storey).length();
        //16 -> 16 % 10
        //2554 -> 2554 % 10 -> 4
        //95 -> ?
        for(int d = 1; d<=digit; d++) {
            long number = storey % (long)Math.pow(10 , d); //자릿수 추출 ex) d =1 일때 2554 % 10 -> 맨 마지막 자리 4가 나옴.

            number = Character.getNumericValue(String.valueOf(number).charAt(0)); // ex) d=2 일때 , 2554 % 100 -> 54 에서 5가 필요.

            if(number > 5) { // 각 자리마다 5가 넘으면 더해버리는게 낫지.
                answer += 10-number;
                storey += (long)Math.pow(10 , d)-(number * (long)Math.pow(10 , d-1)); // d =2 일때 100 - number * 10^1
            }else if(number == 5 && d <digit && Character.getNumericValue(String.valueOf(storey).charAt(d)) >=5 ) {
                //앞자리수가 남아있을때 지금 자릿수의 숫자가 5고 그 다음숫자가 5이상일때 ex) 95
                //이것도 더하는게 나아..
                answer += 10-number;
                storey += (long)Math.pow(10 , d)-(number * (long)Math.pow(10 , d-1)); // d =2 일때 100 - number * 10^1
            } // 현재 숫자가 5이하라면 그냥 뺴버려
            else {
                answer += number;
                storey -= number * (long)Math.pow(10 , d-1);
            }
        }

        //9999 -> 10000 처럼 자릿수가 바뀌면
        if(storey != 0) {
            answer+=1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(95));
    }
}