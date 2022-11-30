package programmers.implement;

public class 기사단원의무기 {
    //약수를 어떻게 구할건지가 관건이져
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            int count = countMeasure(i);
            System.out.println(count);
            if(count > limit) answer += power;
            else answer += count;
        }
        return answer;
    }

    //약수구하기 , 약수개수
    int countMeasure(int num) {
        int count = 0;
        int sqrt = (int) Math.sqrt(num);
        for(int i=1; i<=sqrt; i++) {
            if(num % i == 0) {
                count++; // add(i)
                if(num / i != i) {
                    count++; // add(num/i)
                }
            }

        }
        return count;
    }
}
