import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0 ,0};
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        List<Integer> temp = new LinkedList();
        
        for(var operation: operations){
            String[] arr = operation.split(" ");
            char op = arr[0].charAt(0);
            int num = Integer.parseInt(arr[1]);
            
            if(op == 'I'){ //큐에 주어진 숫자를 삽입합니다.
                queue.add(num);
            }
            else if(queue.size() == 0){ //우선순위 큐가 비어있으므로 최댓값 삭제 연산이 무시됩니다.
                continue;
            }
            else if(op == 'D' && num == -1){ //큐에서 최솟값을 삭제합니다.
                queue.remove();
            }
            else{ //큐에서 최댓값을 삭제합니다.
                if(queue.size() == 1){ //큐에 값이 하나라면 그거 삭제
                    queue.remove();
                    continue;
                }
                while(queue.size() > 1){ //1. 큐에 있는 모든 값 순서대로 list에 옮김 (최대값인 마지막 요소 빼고)
                    temp.add(queue.remove());
                }
                queue.clear(); //2. 큐 초기화
                for(int tempNum : temp){ //3. 리스트에 있는 거 다시 큐로 넣음
                    queue.add(tempNum);
                }
                temp = new LinkedList();
            }
            
        }
        
        if(queue.size() > 0){
            int min = queue.remove(); // 큐 처음에 있는 값이 최소값
            while(queue.size() > 1){
                queue.remove();
            }
            int max = queue.remove(); //큐 마지막에 있는 값이 최대값
            
            return new int[]{max, min};
        }
        
        return answer;
    }
}