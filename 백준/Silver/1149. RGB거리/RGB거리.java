import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][3];
        int[][] dp = new int[n][3];

        for(int i=0; i<n; i++) {
            String[] row = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                data[i][j] = Integer.parseInt(row[j]);
            }
        }

        dp[0] = data[0];

        for(int i=1; i<n; i++) {
            for(int j=0; j<3; j++) {
                if(j == 0) {
                    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + data[i][0];
                }

                if(j == 1) {
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + data[i][1];
                }

                if(j == 2) {
                    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + data[i][2];
                }
            }
        }

        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
    }

}
