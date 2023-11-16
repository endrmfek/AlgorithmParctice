import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int s;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if (s == 0) {
            answer--;
            System.out.println(answer);
        }else {
            System.out.println(answer);
        }
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        
        dfs(depth+1, sum + arr[depth]);
        dfs(depth+1, sum);
    }

}
