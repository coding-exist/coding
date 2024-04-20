import java.util.*;
class Point{
    int x, y, count;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    Point(int x, int y, int count){
        this(x, y);
        this.count = count;
    }
}
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        Point character = new Point(characterY* 2, characterX* 2);
        Point item = new Point(itemY* 2, itemX* 2);
        
        int[][] graph = new int[102][102];
        
        for(var rect : rectangle){
            int x1 = rect[0] * 2, y1 = rect[1] * 2, x2 = rect[2] * 2, y2 = rect[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                 
                    if (i == x1 || i == x2 || j == y1 || j == y2)
                    {
                        graph[j][i] = graph[j][i] == 2 ? 2 : 1;
                    }
                    else graph[j][i] = 2;
                }
            }
        }
        
        answer = getItem(graph, character, item);
        return answer/2;
    }
    public int getItem(int[][] graph, Point character, Point item){
        Queue<Point> queue = new LinkedList();
        
        queue.add(character);
        graph[character.x][character.y] = 2;
        
        while(!queue.isEmpty()){
            Point current = queue.poll();
            
            if(current.x == item.x && current.y == item.y){
                return current.count;
            }
            
            for(int i=0; i<4; i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                
                if(graph[newX][newY] == 0) continue;
                
                if(graph[newX][newY] == 1){
                    queue.add(new Point(newX, newY, current.count+1));
                    graph[newX][newY] = 2;
                }
            }
        }
        return 0;
    }
}

