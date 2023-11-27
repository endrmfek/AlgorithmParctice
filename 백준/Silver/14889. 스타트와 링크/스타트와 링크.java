import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combi(0, 0);
        System.out.println(min);

    }

    private static void combi(int depth, int start) {
        if(depth == N/2) {
            sum();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combi(depth+1, i+1);
            visited[i] = false;
        }

    }

    private static void sum() {
        int lsum = 0;
        int rsum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    lsum += arr[i][j] + arr[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    rsum += arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(lsum - rsum));
    }
}