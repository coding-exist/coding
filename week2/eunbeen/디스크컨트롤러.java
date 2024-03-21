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
        // 시작 시간이 빠른 순서대로 저장
        Queue<Job> readyQueue = new PriorityQueue(new Comparator<Job>() {
            public int compare(Job j1,Job j2) {
                return j1.start - j2.start;
            }
        });
        
        // 실행 시간이 빠른 순서대로 저장
        Queue<Job> jobQueue = new PriorityQueue(new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.progress - j2.progress;
            }
        });
        
        // 수행해야 하는 컨트롤러
        for(int[] arr : jobs){
            readyQueue.add(new Job(arr[0], arr[1]));
        }
        
        int currentTime = 0;
        
        while(readyQueue.size() > 0 || jobQueue.size() > 0){

            //1. ready에서 실행할 수 있는 작업을 job으로 넘김
            while(readyQueue.size() > 0 && currentTime >= readyQueue.peek().start){
                jobQueue.add(readyQueue.remove());
            }
            
            //2. job이 있으면 실행함
            if (jobQueue.size() > 0){
                Job job = jobQueue.remove();

                //실행되는 시간
                answer += (currentTime + job.progress - job.start);

                //현재 시간 += 실행시간
                currentTime += job.progress;
            }
            // 3. job이 없으면 현재 시간을 흘러가게 함
            else currentTime += 1;
        }
        
        return (int) answer/jobs.length;
    }
}