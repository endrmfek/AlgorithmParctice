package programmers.dp;

import java.util.*;

public class 숫자변환하기 {

    /**
     * x에 n을 더합니다
     * x에 2를 곱합니다.
     * x에 3을 곱합니다.
     */

    //x to y
    public static int solution(int x, int y, int n) {

        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for(int i=x; i<=y-n; i++) {

            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            if(i+n <= y) {
                dp[i+n] =Math.min(dp[i]+1, dp[i+n]);
            }

            if(i*2 <= y) {
                dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
            }

            if(i*3 <= y) {
                dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
            }

        }

        return (dp[y] == Integer.MAX_VALUE) ? -1 : dp[y];
    }

    public int solution2(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }

    public int bfs(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> visit = new HashMap<>();
        q.offer(x);
        while(!q.isEmpty()) {
            int num = q.poll();
            int cnt = visit.getOrDefault(num, 0);
            if(num == y) return cnt;
            if(num + n <= y && !visit.containsKey(num + n)) {
                q.offer(num + n);
                visit.put(num + n, cnt + 1);
            }
            if(num * 2 <= y && !visit.containsKey(num * 2)) {
                q.offer(num * 2);
                visit.put(num * 2, cnt + 1);
            }
            if(num * 3 <= y && !visit.containsKey(num * 3)) {
                q.offer(num * 3);
                visit.put(num * 3, cnt + 1);
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(solution(10,40,5));
    }
}
