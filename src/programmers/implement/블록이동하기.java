package programmers.implement;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {
    int map[][];
    int n;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean row[][];
    boolean col[][];
    int answer;
    public int solution(int[][] board) {
        n = board.length;
        map = new int[n][n];
        row = new boolean[n][n];
        col = new boolean[n][n];
        for(int i=0; i<n; i++) {
            map[i] = board[i].clone();
        }

        row[0][0] = true;
        row[0][1] = true;

        bfs();

        return answer;
    }

    void bfs() {
        Queue<Robot> q = new LinkedList<>();
        q.add(new Robot(new Point(0,0) , new Point(0,1), 0));
        q.add(new Robot(null, null, -1)); // 움직였을때.
        int count = 0;

        while(!q.isEmpty()) {
            Robot now = q.poll();

            if(now.dir == -1) { // 움직임이 끝났으면 count up
                count++;
                if(!q.isEmpty()) {
                    q.add(new Robot(null,null,-1));
                    continue;
                }
            }

            if((now.p1.x == n-1 && now.p1.y == n-1) || (now.p2.x == n-1 && now.p2.y == n-1)) {
                answer = count;
                break;
            }

            if(now.dir == 0) { // 가로방향이라면

                //좌우상하로 갈 수 있니?
                for(int i=0; i<4; i++) {
                    int nextP1X = now.p1.x + dx[i];
                    int nextP1Y = now.p1.y + dy[i];
                    int nextP2X = now.p2.x + dx[i];
                    int nextP2Y = now.p2.y + dy[i];

                    if(check(nextP1X , nextP1Y) && check(nextP2X, nextP2Y)) { // 갈 수 있냐?
                        if(!(row[nextP1X][nextP1Y] && row[nextP2X][nextP2Y])) { //안가봤으면
                            row[nextP1X][nextP1Y] = true;
                            row[nextP2X][nextP2Y] = true;
                            q.add(new Robot(new Point(nextP1X, nextP1Y) , new Point(nextP2X, nextP2Y) , 0));
                        }

                    }
                }
                //회전할 수 있니? -> 가로일땐 상하만 체크하면 됨.
                for(int i=-1; i<=1; i+=2) {
                    int nP1X = now.p1.x + i;
                    int nP1Y = now.p1.y;
                    int nP2X = now.p2.x + i;
                    int nP2Y = now.p2.y;

                    if(check(nP1X,nP1Y) && check(nP2X, nP2Y)) {
                        if(rotate(nP1X,nP1Y,now.p1.x,now.p1.y) && (!(col[nP1X][nP1Y] && col[now.p1.x][now.p1.y]))) {
                            col[nP1X][nP1Y] = true;
                            col[now.p1.x][now.p1.y] = true;
                            q.add(new Robot(new Point(nP1X,nP1Y) , new Point(now.p1.x, now.p1.y), 1));
                        }

                        if(rotate(nP2X,nP2Y,now.p2.x,now.p2.y) && (!(col[nP2X][nP2Y] && col[now.p2.x][now.p2.y]))) {
                            col[nP2X][nP2Y] = true;
                            col[now.p2.x][now.p2.y] = true;
                            q.add(new Robot(new Point(nP2X,nP2Y) , new Point(now.p2.x, now.p2.y), 1));
                        }
                    }
                }
            } else {
                for(int i = 0; i < 4; i++) {
                    int np1X = now.p1.x + dx[i];
                    int np1Y = now.p1.y + dy[i];
                    int np2X = now.p2.x + dx[i];
                    int np2Y = now.p2.y + dy[i];

                    if(check(np1X, np1Y) && check(np2X, np2Y)) {
                        if(!col[np1X][np1Y] || !col[np2X][np2Y]) {
                            Robot next = new Robot(new Point(np1X, np1Y), new Point(np2X, np2Y), 1);
                            col[np1X][np1Y] = true;
                            col[np2X][np2Y] = true;
                            q.add(next);
                        }
                    }
                }
                for(int i = -1; i <= 1; i+=2) {
                    int np1X = now.p1.x;
                    int np1Y = now.p1.y + i;
                    int np2X = now.p2.x;
                    int np2Y = now.p2.y + i;

                    if(check(np1X, np1Y) && check(np2X, np2Y)) {
                        if(rotate(np1X, np1Y, now.p1.x, now.p1.y) && (!row[np1X][np1Y] || !row[now.p1.x][now.p1.y])) {
                            row[np1X][np1Y] = true;
                            row[now.p1.x][now.p1.y] = true;
                            q.add(new Robot(new Point(np1X, np1Y), new Point(now.p1.x, now.p1.y), 0));
                        }
                        if(rotate(np2X, np2Y, now.p2.x, now.p2.y) && (!row[np2X][np2Y] || !row[now.p2.x][now.p2.y])) {
                            row[np2X][np2Y] = true;
                            row[now.p2.x][now.p2.y] = true;
                            q.add(new Robot(new Point(np2X, np2Y), new Point(now.p2.x, now.p2.y), 0));
                        }
                    }
                }
            }


        }
    }

    boolean rotate(int x1, int y1, int x2, int y2) {
        return check(x1, y1) && check(x2, y2);
    }

    boolean check(int x, int y) {
        return x >= 0 && x <n && y>=0 && y<n && map[x][y] ==0;
    }

    class Robot {
        Point p1 , p2;
        int dir;
        Robot(Point p1, Point p2 , int dir) {
            this.p1 = p1;
            this.p2 = p2;
            this.dir = dir;
        }
    }

    class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        블록이동하기 a = new 블록이동하기();
        a.solution(new int[][] {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}});
    }
}
