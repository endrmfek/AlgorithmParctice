import java.io.*;
import java.util.*;

public class Main {

    static int m,n,k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dm = {0, 0, 1, -1};
    static int[] dn = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int startN = Integer.parseInt(st.nextToken());
            int startM = Integer.parseInt(st.nextToken());
            int endN = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            for(int r=startM; r<endM; r++) {
                for(int c=startN; c<endN; c++) {
                    map[r][c] = 1;
                }
            }
        }
        int cnt = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    int result = bfs(i, j);
                    answer.add(result);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(cnt);
        for(int value : answer) {
            System.out.print(value + " ");
        }

    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowM = now[0];
            int nowN = now[1];

            for(int i=0; i<4; i++) {
                int nextM = nowM + dm[i];
                int nextN = nowN + dn[i];
                if(0<=nextM && nextM < m && 0<=nextN && nextN < n) {
                    if(map[nextM][nextN] == 0 && !visited[nextM][nextN]) {
                        cnt++;
                        visited[nextM][nextN] = true;
                        q.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return cnt;
    }


}
