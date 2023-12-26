import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] row = br.readLine().split(" ");
            for(int j=0; j<row.length; j++) {
                data[i][j] = Integer.parseInt(row[j]);
            }
        }

        dp[0][0] = data[0][0];

        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + data[i][j];
                    continue;
                }

                if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + data[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + data[i][j];
            }
        }

        System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());

    }

}
