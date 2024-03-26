#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers)
{
    vector<vector<int>> students = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

    vector<int> correct = {0, 0, 0};
    for (int i = 0; i < answers.size(); i++)
    {
        int answer = answers[i];
        for (int j = 0; j < 3; j++)
        {
            int current = i % students[j].size();
            if (students[j][current] == answer)
                correct[j]++;
        }
    }

    vector<int> answer;
    int max = *max_element(correct.begin(), correct.end());
    for (int i = 0; i < 3; i++)
    {
        if (correct[i] == max)
            answer.push_back(i + 1);
    }
    return answer;
}