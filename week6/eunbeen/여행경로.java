import java.util.*;

class Solution {
    Stack<String> answer;
    Map<String, List<String>> arrive;
    public String[] solution(String[][] tickets) {
        arrive = new HashMap();
        answer = new Stack();
        
        for(var item : tickets){            
            arrive.putIfAbsent(item[0], new ArrayList());
            arrive.get(item[0]).add(item[1]);
        }
        
        arrive.values().forEach(list -> Collections.sort(list));
        DFS(0, "ICN", tickets.length);
                
        return answer.stream().toArray(String[]::new);
    }
    public void DFS(int index, String start, int ticketCount){
        
        if(!arrive.containsKey(start) || arrive.get(start).size() == 0){
            if(index == ticketCount){
                answer.add(start);
            }
            return;
        }
        
        var list = arrive.get(start);
        answer.push(start);
        
        for (int i=0; i<list.size(); i++)
        {
            String end = list.remove(i);
            DFS(index + 1, end, ticketCount);
            if(arrive.values().stream().allMatch(List::isEmpty)) {
                return;
            }
            list.add(i, end);
        }

        answer.pop();
    }
}