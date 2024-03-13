using System;
using System.Text;
using System.Linq;

public class Solution {
    public string solution(int[] numbers) {
        var answer = new StringBuilder();
        
        Array.Sort(numbers, compare);
        
        if(numbers[numbers.Length-1] == 0) return "0";
        for(int i=numbers.Length-1; i>=0; i--){
            answer.Append(numbers[i].ToString());
        }
        
        
        return answer.ToString();
    }
    public int compare(int a, int b){
        string ab = a.ToString() + b.ToString();
        string ba = b.ToString() + a.ToString();
        
        return string.Compare(ab, ba);
    }
}