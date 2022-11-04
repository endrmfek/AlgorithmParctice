class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        int min = 0;
        int max = cores[0] * n; // 하나하나씩 처리하는게 시간이 제일 오래걸리지.

        int time = 0;
        int m = 0;

        while(min <= max) {
            int mid = (min + max) / 2; // 최적의 시간

            int count = countWork(mid, cores); // 그시간에 작업처리 얼마나?

            if(count >= n) { //max를 구하기때문에
                max = mid-1;
                time = mid; // 최적의 시간에
                m = count; // 몇개를 할건지
            } else {
                min = mid+1;
            }
        }
        
        m -= n;
        for(int i= cores.length-1; i>=0; i--) {
            if(time % cores[i] == 0) {
                if(m==0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }
        return answer;
    }
    int countWork(int time, int[] cores) {
        if(time ==0) {
            return cores.length;
        }
        int count = cores.length;
        
        for(int i=0; i<cores.length; i++) {
            count += (time / cores[i]);
        }
        return count;
    }
}