import java.util.*;
class Solution {
    //지도는 직사각형 형태입니다.
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    boolean[][] visited;
    char[][] map;
    int result = 0;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        char[][] map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        //초기화
        for (int i=0;  i<maps.length; i++) {
            char[] mapRow = maps[i].toCharArray();
            for(int j=0; j<mapRow.length; j++) {
                map[i][j] = mapRow[j];
            }
        }

        boolean flag = false;
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    if(dfs(i,j, map)) {
                        flag = true;
                        answer.add(result);
                        result = 0;
                    }
                }
            }
        }
        if(!flag) {
            return new int[]{-1};
        }

        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private boolean dfs(int x, int y, char[][] map) {
        if(x <0 || x >=map.length || y<0 || y>=map[0].length || visited[x][y]) {
            return false;
        }
        

        if(Character.isDigit(map[x][y])) {
            visited[x][y] = true;
            result += map[x][y] - '0';
            dfs(x+1, y, map);
            dfs(x-1, y, map);
            dfs(x, y+1, map);
            dfs(x, y-1, map);

            return true;
        }

        return false;
    }
}