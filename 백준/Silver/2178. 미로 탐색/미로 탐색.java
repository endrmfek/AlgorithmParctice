import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //(1,1) 에서 시작해서 N,M 까지.
        map = new int[N][M];

        for(int i=0; i<N;  i++) {
            String row = br.readLine();
            for(int j=0; j<row.length(); j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(0<= nx && nx < N && 0<= ny && ny < M) {
                    if(map[nx][ny] == 1) {
                        map[nx][ny] = map[now[0]][now[1]] + 1;
                        q.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}