class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(long x=0; x<=d; x=x+k) {
            long y = (long) Math.sqrt((long) d *d - x*x) / k;
            answer += y+1;
        }
        return answer;
    }
}