import java.util.*;
class Solution {
    //시작 0,0
    //처음가보는길
	static char[] dir = {'U', 'R', 'D', 'L'};
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
    public static int solution(String dirs) {
        int answer = 0;
        int x=0, y=0;
        Queue<Character> q = new LinkedList<>();
        ArrayList<XY> data = new ArrayList<>();
        
        for(int i=0; i<dirs.length(); i++) {
        	q.offer(dirs.charAt(i));
        }
        System.out.println(new XY(0,0,'U').equals(new XY(0,0,'U')));
        while(!q.isEmpty()) {
        	char now = q.poll();
        	int dirIndex = 0;
        	
        	for(int i=0; i<4; i++) {
        		if(dir[i] == now) {
        			int nx = x + dx[i];
        			int ny = y + dy[i];
        			dirIndex = i;
        			
        			if(nx <= 5 && nx >= -5 && ny >= -5 && ny <= 5) {
                		
                		//막혔지 여기서. -5 ~ 5 방문체크 어떻게 할거야?
                		XY node = new XY(nx,ny,dirIndex);
                		if(!data.contains(node)) {
                			// System.out.println("x = " + nx + " y = " + ny + " dir = " + dir[dirIndex]);
                			data.add(node);
                			dirIndex = (dirIndex % 2 == 0)? 2 - dirIndex : 4-dirIndex;
                			data.add(new XY(x,y,dirIndex));
                			answer += 1;
                		}
                		x = nx;
            			y = ny;
                	}  
        		}
        	}
        }
        return answer;
    }
}
class XY {
	int x;
	int y;
	int dir;
	
	XY(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dir, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XY other = (XY) obj;
		return dir == other.dir && x == other.x && y == other.y;
	}
	
}