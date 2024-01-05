import java.io.*;
import java.util.*;

public class Main {

    //연속으로 놓여있는 3잔을 모두 마실 수 없다. -> 이거 어떻게 해결할건데?
    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i=1; i<=n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        //로직 시작
        dp[1] = data[1];
        if(n >= 2) {
            dp[2] = dp[1] + data[2];
        }

        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + data[i], dp[i - 3] + data[i - 1] + data[i]));
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
