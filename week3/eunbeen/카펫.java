class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};

        int h = 1;
        while(true){
            int w = (brown/2)-h+2;
            if((w*h)-brown == yellow){
                return new int[] {w, h};
            }
            h++;
        }
    }
}