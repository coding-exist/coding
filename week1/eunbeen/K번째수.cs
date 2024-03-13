using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] array, int[,] commands) {
        int[] answer = new int[commands.GetLength(0)];
        List<int> list = new List<int>();
        
        for(int z=0; z<commands.GetLength(0); z++){
            int i = commands[z, 0];
            int j = commands[z, 1];
            int k = commands[z, 2];
            
            for(int x=i-1; x<j; x++){
                list.Add(array[x]);
            }
            list.Sort();
            answer[z] = list.ToArray()[k-1];
            list.Clear();
        }
        
        return answer;
    }
}