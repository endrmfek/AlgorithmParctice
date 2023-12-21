import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);

        System.out.println(result-1);
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(now == K) {
                return visited[now];
            }

            if (now-1 >=0 && visited[now-1] == 0) {
                visited[now-1] = visited[now] + 1;
                q.add(now-1);
            }

            if(now+1 < 100001 && visited[now+1] == 0) {
                visited[now+1] = visited[now] + 1;
                q.add(now+1);
            }

            if(now*2 < 100001 && visited[now*2] == 0) {
                visited[now*2] = visited[now] + 1;
                q.add(now*2);
            }
        }

        return 0;
    }

}