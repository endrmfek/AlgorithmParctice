import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1];
        Arrays.fill(arr, true);

        arr[0] = false;
        arr[1] = false;

        for (int i=2; i <= Math.sqrt(N)+1; i++) {
            if (arr[i]) {
                for (int j=i*i ; j<=N; j=j+i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }

}
