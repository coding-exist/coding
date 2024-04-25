import java.util.*;
class Word{
    int count;
    String str;
    
    Word(int count, String str){
        this.count = count;
        this.str = str;
    }
    
    public boolean isTransferWord(String another){
        char[] arr1 = this.str.toCharArray();
        char[] arr2 = another.toCharArray();
        
        int diff = 0;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]){
                diff += 1;
            }
        }
        
        return diff > 1 ? false : true;
    }
    
    @Override
    public String toString(){
        return str + ", count " + count + "\n";
    }
    
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(!Arrays.stream(words).anyMatch(target::equals)){
            return 0;
        }
        
        answer = bfs(begin, target, words);
        return answer;
    }
    private int bfs(String begin, String target, String[] words){
        Queue<Word> queue = new LinkedList();
        boolean[] check = new boolean[words.length];
        
        queue.add(new Word(0, begin));
        
        while(!queue.isEmpty()){
            var current = queue.poll();
            
            if(current.str.equals(target)){
                return current.count;
            }
            
            for(int i=0; i<words.length; i++){
                if(current.isTransferWord(words[i]) && !check[i]){
                    check[i] = true;
                    queue.add(new Word(current.count + 1, words[i]));
                }
            }
        }
        
        return 0;
    }
}