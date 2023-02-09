class Solution {
    //가격이 떨어지지 않은 기간?
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j< prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) {
                    //떨어지면
                    break;
                }
            }
        }
        return answer;
    }
}