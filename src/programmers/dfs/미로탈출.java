package programmers.dfs;

import java.util.Arrays;

public class 미로탈출 {
    static int row;
    static int col;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int leverX;
    static int leverY;

    static final int E = 1000000001;
    static final int L = 1000000002;
    static int[][] data;
    static boolean[][] visited;

    public int solution(String[] maps) {
        int answer = 0;
        row = maps.length;
        col = maps[0].length();

        data = new int[row][col];
        visited = new boolean[row][col];
        init(maps, data);
        dfs(startX, startY, 0);

        if(!visited[leverX][leverY]) {
            return -1;
        } else {
            answer += data[leverX][leverY];

            data = new int[row][col];
            visited = new boolean[row][col];
            init(maps, data);
            dfs(leverX, leverY, 0);

            if(!visited[endX][endY]) {
                return -1;
            } else {
                answer += data[endX][endY];
                return answer;
            }
        }

    }

    public void init(String[] maps , int[][] data) {
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }

                if(maps[i].charAt(j) == 'X') {
                    data[i][j] = -1;
                }

                if(maps[i].charAt(j) == 'E') { //끝
                    data[i][j] = E;
                    endX = i;
                    endY = j;
                }

                if(maps[i].charAt(j) == 'L') { //레버
                    leverX = i;
                    leverY = j;
                    data[i][j] = L;
                }
            }
        }
    }

    //일단 레버를 밟아야 나갈 수 있어.
    //레버까지의 최소거리 -> 레버에서 마지막까지 최소거리 ㅇㅋ?
    public boolean dfs(int x, int y, int now) {

        if(x >= 0 && x <row && y >= 0 && y < col && !visited[x][y]) {

            if(data[x][y] == -1) { //벽이면
                return false;
            }

            visited[x][y] = true;
            data[x][y] = now;
            dfs(x-1,y, now+1);
            dfs(x+1,y, now+1);
            dfs(x,y-1, now+1);
            dfs(x,y+1, now+1);
            return true;
        }

        return false;
    }

}