import java.util.*;
class Solution {
    String[][] map;
    int row, col;
    int startX, startY;
    int endX, endY;
    boolean[][] visited;
    int[][] scoreMap;

    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    public int solution(String[] board) {
        int answer = 0;
        row = board.length;
        col = board[0].length();
        map = new String[row][col];
        visited = new boolean[row][col];
        scoreMap = new int[row][col];

        for(int i=0; i<row; i++) {
            Arrays.fill(scoreMap[i], 10000001);
        }
        //맵 초기화
        init(board);


        answer = dfs(startX, startY, 0,1000001);

        if(answer == 1000001) {
            return -1;
        } else {
            return answer;
        }
    }

    public int dfs(int x, int y, int count , int minCount) {
        int m = minCount;

        if(map[x][y].equals("G")) {
            System.out.println(x + " " + y + " " +count + " " + minCount);
            return Math.min(count, m);
        }

        //다음 노드를 구해야될걸?
        for(int i=0; i<4; i++) {
            int[] next = findNext(i, x, y);

            if( !(x == next[0] && y == next[1]) && !visited[next[0]][next[1]] && (count+1 < scoreMap[next[0]][next[1]])) {
                //System.out.println(x + " " + y + " " + Arrays.toString(next) + " " + visited[next[0]][next[1]] + " " + count + " " + " " +scoreMap[next[0]][next[1]]);
                visited[next[0]][next[1]] = true;
                scoreMap[next[0]][next[1]] = count+1;
                m = dfs(next[0],next[1], count+1, m);
                visited[next[0]][next[1]] = false;
            }
        }

        return m;
    }

    public int[] findNext(int dir, int x, int y) {
        int nX = x;
        int nY = y;

        while(true) {
            //System.out.println(nX + " " + nY + " " + dir);
            if(nX + dx[dir] < 0 || nX + dx[dir] >= row) {
                return new int[]{nX,nY};
            }

            if(nY + dy[dir] < 0 || nY + dy[dir] >= col) {
                return new int[]{nX,nY};
            }

            if(map[nX + dx[dir]][nY + dy[dir]].equals("D")) {
                return new int[]{nX,nY};
            }
            nX += dx[dir];
            nY += dy[dir];
        }
    }
    public void init(String[] board) {
        for(int i=0; i<row; i++) {
            String[] rowData = board[i].split("");
            //System.out.println(rowData.length);
            for(int j=0; j<col; j++) {
                map[i][j] = rowData[j];

                if(map[i][j].equals("R")) {
                    startX = i;
                    startY = j;
                }

                if(map[i][j].equals("G")) {
                    endX = i;
                    endY = j;
                }
            }
        }
    }

}