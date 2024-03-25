#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Process
{
    int index;
    int priority;
};

int solution(vector<int> priorities, int location) {
    queue<Process> processQ;
    for (int i = 0; i < priorities.size(); i++)
    {
        processQ.push({ i, priorities[i]});
    }

    sort(priorities.begin(), priorities.end());
    
    int executionCount = 0;
    while(!processQ.empty())
    {
        auto front = processQ.front();
        if (front.priority == priorities.back())
        {
            executionCount++;
            if (front.index == location)
                return executionCount;

            processQ.pop();
            priorities.pop_back();
        }
        else
        {
            processQ.push(front);
            processQ.pop();
        }
    }
    return executionCount;
}