import java.io.*;
import java.util.*;

public class Main {

    static int cnt;
    static int[] node;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        while(test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            node = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                node[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            //여기서 이제 싸이클 판별해야지
            for(int i=1; i<=n; i++) {
                if(!finished[i]) {
                    dfs(i);
                }
            }
            System.out.println(n-cnt);
        }
    }

    public static void dfs(int now) {
        visited[now] = true;
        int next = node[now];

        if(!visited[next]) { //방문을 안했으면?
            dfs(next);
        } else { //방문을 했으면?
            //이때부터 싸이클인데
            //1. 이번 반복에서 방문했을까? -> 싸이클임
            if(!finished[next]) {
                cnt++;
                while(now != next) {
                    cnt++;
                    next = node[next];
                }
            }
            //2. 이전 반복에서 방문했을까? -> 신경안써도됨 (이미 처리했음)
        }
        finished[now] = true;
    }
}
