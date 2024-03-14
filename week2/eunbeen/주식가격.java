class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++){
            int count = 0;
            for(int j=i; j<prices.length; j++){
                count += 1;
                if(prices[j] < prices[i]) break;
            }
            answer[i] = count-1;
        }
        
        return answer;
    }
}