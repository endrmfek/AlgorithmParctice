import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for(int i=0; i<n; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        //로직
        int minValue = 0;
        for(int i=coins.length-1; i>=0; i--) {
            int nowCoin = coins[i];
            if(nowCoin > goal) {
                continue;
            }
            minValue += goal / nowCoin;
            goal %= nowCoin;
            if(goal ==0) {
                break;
            }
        }
        System.out.println(minValue);
    }
}
