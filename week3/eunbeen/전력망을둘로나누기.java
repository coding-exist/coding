import java.util.*;

class Graph{
    int node;
    Set<Integer> list[];

    Graph(int node){
        this.node = node;
        this.list = new HashSet[node+1];

        for (int i=1; i<node+1; ++i){
            list[i] = new HashSet<Integer>();
        }
    }

    void edge(int a, int b){
        list[a].add(b);
        list[b].add(a);
    }

    void remove(int v1, int v2){
        list[v1].remove(v2);
        list[v2].remove(v1);
    }
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<node+1; ++i){
            sb.append(i).append(": ");
            for(var item : list[i]){
                sb.append(item).append(" ");
            }
            sb.append("\n");
        }
        
       return sb.toString();
    }
}
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 10000;
        
        Graph graph = new Graph(n);
        
        for(int[] wire : wires){
            var v1 = wire[0];
            var v2 = wire[1];
            graph.edge(v1, v2);
        }
        
        for(int i=0; i<n-1; i++){
            var v1 = wires[i][0];
            var v2 = wires[i][1];
            
            graph.remove(v1, v2);
            int num1 = BFS(v1, graph, n);
            int num2 = BFS(v2, graph, n);
            
            answer = Math.min(answer, Math.abs(num1-num2));
            graph.edge(v1, v2);
        }
        
        return answer;
    }
    private int BFS(int index, Graph graph, int n){
        Queue<Integer> queue = new LinkedList();
        boolean[] check = new boolean[n+1];
        int count = 1;
        
        check[index] = true;
        queue.add(index);
        
        while(queue.size() > 0){
            index = queue.remove();
            
            Iterator<Integer> iter = graph.list[index].iterator();
            while(iter.hasNext()){
                int num = iter.next();
                if(!check[num]){
                    check[num] = true;
                    queue.add(num);
                    count += 1;
                }
            }
        }
        
        return count;
    }
}

// 전선을 하나씩 다 잘라서 확인해보기
// 1. 전선 하나 자르기
// 2. 한 공간의 개수 세기
// 3. 또 다른 공간의 개수 세기
// 4. 두 공간의 개수 차이 절대값 (min) 으로 구하기
// 5. 다시 전선 붙이기