import java.util.*;
class Island implements Comparable<Island> {
    int src;
    int dest;
    int cost;
    
    Island(int src, int dest, int cost){
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Island other){
        return Integer.compare(this.cost, other.cost);
    }
}
class Solution {
    public static int answer = 0;
    public int solution(int n, int[][] costs) {
        List<Island> list[] = new ArrayList[n];
        
        for (int i=0; i<n; ++i){
            list[i] = new ArrayList<Island>();
        }
        
        for(var cost: costs){
            list[cost[0]].add(new Island(cost[0], cost[1], cost[2]));
            list[cost[1]].add(new Island(cost[1], cost[0], cost[2]));
        }
        
        List<Island> mst = new ArrayList<>();
        int mstCost = 0;
        PriorityQueue<Island> queue = new PriorityQueue();
        boolean[] check = new boolean[n];
        
        check[0] = true;
        list[0].forEach(queue::add);
        
        while(!queue.isEmpty()){
            var island = queue.poll(); //가장 싼 다리 선택
            
            if (check[island.dest]) continue;
            
            check[island.dest] = true;
            mst.add(island);
            mstCost += island.cost;
            
            for(var next : list[island.dest]){
                if (!check[next.dest]) {
                    queue.add(next);
                }
            }
        }
        
        return mstCost;
    }
}