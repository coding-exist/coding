import java.util.*;

class Solution {
    List<String> words = new ArrayList();
    public int solution(String word) {
        int answer = 0;
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
        
        for (int i = 1; i <= alphabet.length; i++){
            findWord("", 0, i, alphabet);
        }
        Collections.sort(words);
        
        answer = words.indexOf(word);
        return answer + 1;
    }
    
    private void findWord(String word, int count, int max, char[] alphabet){
        if (count == max){
            words.add(word);
            return;
        }

        for (int i = 0; i < alphabet.length; i++){
            findWord(word + alphabet[i], count+1, max, alphabet);
        }
    }
}