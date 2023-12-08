import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    static int house = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    house++;
                    dfs(i,j, map, visited);
                    result.add(count);
                }
            }
        }

        System.out.println(house);

        Collections.sort(result);
        for(int num : result) {
            System.out.println(num);
        }

    }

    public static void dfs(int x, int y, int[][] map, boolean[][] visited) {
        visited[x][y] = true;
        map[x][y] = house;
        count++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx,ny,map,visited);
                }
            }
        }
    }

}