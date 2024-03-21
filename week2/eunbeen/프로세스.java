import java.util.*;

class Item implements Comparable<Item>{
    public int process;
    public int priority;
    
    public Item(int process, int priority){
        this.process = process;
        this.priority = priority;
    }
     
    @Override
    public int compareTo(Item i){
        //우선순위 순으로 정렬
        return i.priority - this.priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Item> priority_queue = new PriorityQueue();
        Queue<Item> queue = new LinkedList();
        
        for(int i=0; i<priorities.length; i++){
            //모든 프로세스가 입력 순서대로 들어감
            queue.add(new Item(i, priorities[i]));
            //모든 프로세스가 우선순위에 맞게 들어감
            priority_queue.add(new Item(i, priorities[i]));
        }
        
        while(queue.size() > 0){
            //1. 우선순위가 높은 프로세스 찾음
            Item priority_item = priority_queue.peek();

            //2. 프로세스 중에 우선순위가 높은 프로세스가 언제 실행되는지 확인하기 위한 무한 루프
            while(true){
                Item item = queue.remove();
                if(item.priority >= priority_item.priority){
                    answer += 1;
                    //3. 우선순위가 높은 프로세스가 실행되는 순서를 찾으면 return
                    if(item.process == location) return answer;
                    //3-1. 현재 우선순위가 가장 높은 프로세스가 실행되어야 하는데 정답과 맞지 않음 = 맨 처음에 있는 프로세스가 가장 우선순위가 높다
                    break;
                }
                queue.add(item);
            }

            priority_queue.remove();
        }
        
        return answer;
    }
}