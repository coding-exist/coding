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
        return i.priority - this.priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Item> priority_queue = new PriorityQueue();
        Queue<Item> queue = new LinkedList();
        
        for(int i=0; i<priorities.length; i++){
            queue.add(new Item(i, priorities[i]));
            priority_queue.add(new Item(i, priorities[i]));
        }
        
        while(queue.size() > 0){
            Item priority_item = priority_queue.peek();
            while(true){
                Item item = queue.remove();
                if(item.priority >= priority_item.priority){
                    System.out.println(item.process + " " +item.priority);
                    answer += 1;
                    
                    
                    if(item.process == location){
                        return answer;
                    }
                    break;
                }
                queue.add(item);
            }
            priority_queue.remove();
        }
        
        return answer;
    }
}