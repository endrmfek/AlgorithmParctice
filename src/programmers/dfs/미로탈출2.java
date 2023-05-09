package programmers.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출2 {
    static String[][] maze;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public int solution(String[] maps) {
        maze = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];

        for(int i=0; i<maps.length; i++) {
            String[] map = maps[i].split("");
            for(int j=0; j<map.length; j++) {
                maze[i][j] = map[j];

                if(maze[i][j].equals("S")) {
                    start = new int[] {i,j};
                }
                if(maze[i][j].equals("L")) {
                    lever = new int[] {i,j};
                }
            }
        }

        int toLever = bfs(start, "L");
        int toEnd = bfs(lever, "E");

        if(toLever == -1 || toEnd == -1) {
            return -1;
        }
        return toLever + toEnd;
    }

    public int bfs(int[] start, String target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1], 0});

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int count = q.peek()[2];
            visited[x][y] = true;

            if(maze[x][y].equals(target)) {
                return count;
            }

            q.poll();

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && nx < maze.length && ny >=0 && ny < maze.length && !visited[nx][ny]) {
                    if(!maze[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx,ny,count+1});
                    }
                }
            }
        }

        return -1;
    }
}
