#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds)
{
    vector<int> answer;

    int lastReleased = 0;
    int tasks = progresses.size();
    while (lastReleased != tasks)
    {
        for (int i = lastReleased; i < tasks; i++)
        {
            progresses[i] += speeds[i];
        }

        if (progresses[lastReleased] >= 100)
        {
            int releaseTasks = 1;
            for (int i = lastReleased + 1; i < tasks; i++)
            {
                if (progresses[i] >= 100)
                    releaseTasks++;
                else
                    break;
            }

            answer.push_back(releaseTasks);
            lastReleased += releaseTasks;
        }
    }

    return answer;
}