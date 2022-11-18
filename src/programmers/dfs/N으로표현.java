package programmers.dfs;

public class N으로표현 {
    int min = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(0,N,number, 0);
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void dfs(int depth, int N, int number, int current) {
        if(depth > 8) {
            return;
        }

        if(number == current) {
            min = Math.min(depth, min);
            return;
        }

        int temp = 0;

        for(int i=0; i<8; i++) {
            if(depth + i < 8) {
                temp = temp*10+N; // 55가 되는 경우는? 5 -> 55
                dfs(depth+i+1, N, number, current+temp);
                dfs(depth+i+1, N, number, current-temp);
                dfs(depth+i+1, N, number, current/temp);
                dfs(depth+i+1, N, number, current*temp);
            }
        }
    }
}
