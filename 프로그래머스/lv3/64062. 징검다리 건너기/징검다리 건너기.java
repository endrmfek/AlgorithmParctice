class Solution {
    //1씩 줄어들어?
    //0이 되면 못가고 그 다음 디딤돌로 갈수있어.
    //그 다음 디딤돌이 여러개면 제일 가까운곳만 갈수있어.
    //친구들수 무제한?
    //전형적인 이진탐색.
    //배열크기 1~20만
    //원소값 1~2억.
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;

        //최대 몇명이야?
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(check(stones, mid, k)) { // 갈 수 있어?
                left = mid + 1;
                answer = mid;
            } else {
                right = mid -1;
            }
        }
        return answer;
    }
    boolean check(int[] stones , long mid , int k) {
        int nope = 0;
        for(int stone : stones) {
            if(stone - mid < 0) { // 갈 수 없어.
                nope++;
            } else { // 다시 갈수 있어.
                nope = 0;
            }
            if(nope == k) return false;
        }

        return true;

    }
}