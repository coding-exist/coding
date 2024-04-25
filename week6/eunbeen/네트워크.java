import java.util.*;

class Network{
    int node;
    List<Integer> list[];
    
    Network(int node){
        this.node = node;
        this.list = new LinkedList[node];

        for (int i=0; i<node; ++i){
            list[i] = new LinkedList<Integer>();
        }
    }
    
    void edge(int e1, int e2){
        list[e1].add(e2);
        list[e2].add(e1);
    }
}

class Solution {
    boolean[] checked = {};
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Network network = new Network(n);
        checked = new boolean[n+1];
        List<Integer> indexs = new ArrayList();
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1){
                    indexs.add(j);
                }
            }
           for(int j=0; j<indexs.size(); j++){
                int newEdge = indexs.get(j);
                for(int z=j+1; z<indexs.size(); z++){
                    network.edge(newEdge, indexs.get(z));
                }
            }
            indexs.clear();
        }
        
        for(int i=0; i<n; i++){
            if(!checked[i]){
                answer += getNetwork(network, n, i);
            }
        }
        
        return answer;
    }
    public int getNetwork(Network network, int n, int index){
        Queue<Integer> queue = new LinkedList();
        
        queue.add(index);
        checked[index] = true;
        
        while(queue.size() > 0){
            index = queue.remove();
            
            Iterator<Integer> iter = network.list[index].iterator();
            while(iter.hasNext()){
                int computer = iter.next();
                if(!checked[computer]){
                    checked[computer] = true;
                    queue.add(computer);
                }
            }
        }
        
        return 1;
    }
    
}