class Solution {
    int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // n이 세로 m이 가로
        int[][] map = new int[n][m];
        
        for(int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        map[0][0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                if(i != 0) {
                    map[i][j] += map[i-1][j] % mod;
                }

                if(j != 0) {
                    map[i][j] += map[i][j-1] % mod;
                }
            }
        }
        return map[n-1][m-1] % mod;
    }
}