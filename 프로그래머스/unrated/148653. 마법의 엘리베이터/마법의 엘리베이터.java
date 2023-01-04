class Solution {
//     단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않습니다
//     버튼 한 번당 마법의 돌 한 개를
    //최소개수
    public static int solution(long storey) {
        int answer = 0;
        //자리수 어떻게 구할거야?
        int digit = String.valueOf(storey).length();

        //16 -> 16 % 10
        //2554 -> 2554 % 10 -> 4
        //95 ->
        for(int d = 1; d<=digit; d++) {
            long number = storey % (long)Math.pow(10 , d); //자릿수 추출

            number = Character.getNumericValue(String.valueOf(number).charAt(0));



            if(number > 5) {
                answer += 10-number;
                storey += (long)Math.pow(10 , d)-(number * (long)Math.pow(10 , d-1)); // d =2 일때 100 - number * 10^1
            }else if(number == 5 && d <digit && Character.getNumericValue(String.valueOf(storey).charAt(d)) >=5 ) {
                answer += 10-number;
                storey += (long)Math.pow(10 , d)-(number * (long)Math.pow(10 , d-1)); // d =2 일때 100 - number * 10^1
            }
            else {
                answer += number;
                storey -= number * (long)Math.pow(10 , d-1);
            }
        }

        if(storey != 0) {
            answer+=1;
        }



        return answer;
    }

}