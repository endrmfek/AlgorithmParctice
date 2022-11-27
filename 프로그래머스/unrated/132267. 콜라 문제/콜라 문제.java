class Solution {
    public int solution(int a, int b, int n) {
        //a를 가져다주면 콜라 b병을 주는 마트. -> n개를 가져다주면 몇개줘?
        //ex) 2개를 가져다주면 1개를줘.
        //n%2 == 1
        int answer = 0;

        while (n >= a) {

            answer += (n / a) * b;
            int temp = n % a;

            n = (n / a) * b + temp;
        }
        return answer;
    }
}