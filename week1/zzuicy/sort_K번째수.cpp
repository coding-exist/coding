#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    int commandsCount = commands.size();
    vector<int> answer(commandsCount);
    
    for (int i = 0; i < commandsCount; i++)
    {
        int start = commands[i][0] - 1;
        int end = commands[i][1];
        int index = commands[i][2] - 1;
                
        vector<int> temp(array);
        sort(temp.begin() + start, temp.begin() + end);
        answer[i] = temp[start + index];
    }
    
    return answer;
}