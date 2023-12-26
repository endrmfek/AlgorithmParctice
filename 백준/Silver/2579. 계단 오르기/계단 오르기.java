import java.io.*;
import java.util.*;

public class Main {

//    계단 오르는 데는 다음과 같은 규칙이 있다.
//    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//    연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//    마지막 도착 계단은 반드시 밟아야 한다.
//    따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
//    각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }
        //ㅇㅋ 한칸 or 두칸 -> dp로 하면돼
        //연속 3칸 할 수 없음 -> 이거 어떻게할건데
        int[] dp = new int[n + 1];

        dp[1] = data[1];
        if(n >= 2) {
            dp[2] = data[1] + data[2];
        }

        for(int i=3;i<=n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+ data[i-1]) + data[i];
        }

        System.out.println(dp[n]);
    }

}
