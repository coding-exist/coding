class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = DFS(numbers, target, 0, 0);
        
        return answer;
    }
    public int DFS(int[] numbers, int target, int sum, int count){
        int cnt = 0;
        if(count == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        cnt += DFS(numbers, target, sum + numbers[count], count+1);
        cnt += DFS(numbers, target, sum + numbers[count] * -1, count+1);
        
        return cnt;
    }
}