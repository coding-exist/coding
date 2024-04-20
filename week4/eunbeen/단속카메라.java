import java.util.*;

class Car implements Comparable<Car>{
    int input, output;
    
    Car(int input, int output){
        this.input = input;
        this.output = output;
    }
    
    @Override
    public int compareTo(Car car){
        return Integer.compare(this.input, car.input);
    }
    
    @Override
    public String toString(){
        return "input: " + input + ", output: " + output;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Stack<Integer> stack = new Stack(); 
        PriorityQueue<Car> queue = new PriorityQueue();
        
        for(var route: routes){
            queue.add(new Car(route[0], route[1]));
        }
        
        while(queue.size() > 0){
            var current = queue.poll();
            int camera = current.output;
            
            while(queue.size() > 0 && queue.peek().input <= camera){
                var next = queue.poll();
                camera = Math.min(next.output, camera);
            }
            answer += 1;
        }
        
        return answer;
    }
}