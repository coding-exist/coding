import java.util.*;
import java.util.Comparator;

class Job{
    int start;
    int progress;
    
    public Job(int start, int progress){
        this.start = start; 
        this.progress = progress;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Queue<Job> readyQueue = new PriorityQueue(new Comparator<Job>() {
            public int compare(Job j1,Job j2) {
                return j1.start - j2.start;
            }
        });
        
        Queue<Job> jobQueue = new PriorityQueue(new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.progress - j2.progress;
            }
        });
        
        for(int[] arr : jobs){
            readyQueue.add(new Job(arr[0], arr[1]));
        }
        
        int currentTime = 0;
        
        while(readyQueue.size() > 0 || jobQueue.size() > 0){

            while(readyQueue.size() > 0 && currentTime >= readyQueue.peek().start){
                jobQueue.add(readyQueue.remove());
            }
            
            if (jobQueue.size() > 0){
                Job job = jobQueue.remove();
                answer += (currentTime + job.progress - job.start);
                currentTime += job.progress;
            }
            else currentTime += 1;
        }
        
        return (int) answer/jobs.length;
    }
}