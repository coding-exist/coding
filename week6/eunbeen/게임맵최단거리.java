import java.util.*;

class Point{
    int x, y, count;
    
    Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
class Solution {
    public int[] dx = new int[] {-1, 0, 1, 0};
    public int[] dy = new int[] {0, -1, 0, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = playGame(maps, maps.length, maps[0].length);
        
        return answer;
    }
    
    private int playGame(int[][] maps, int n, int m){
        Queue<Point> queue = new LinkedList();
        boolean[][] checked = new boolean[n][m];
        
        queue.add(new Point(0, 0, 0));
        checked[0][0] = true;
        
        while(queue.size() > 0){
            Point point = queue.remove();
            
            if(point.x == n-1 && point.y == m-1){
                return point.count+1;
            }
            
            for(int i=0; i<4; i++){
                int newX = dx[i] + point.x;
                int newY = dy[i] + point.y;
                
                if(newX < 0 || newY < 0 || newX >=n || newY >= m) continue;
                if(maps[newX][newY] == 0) continue;
                
                if(!checked[newX][newY]){
                    
                    queue.add(new Point(newX, newY, point.count+1));
                    checked[newX][newY] = true;
                    //count += 1;
                }
            }
        }
        
        return -1;
    }
}