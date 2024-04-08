#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve)
{
    vector<int> uniformCount(n + 1, 1);
    uniformCount[0] = 0;
    for (auto student : lost)
    {
        uniformCount[student] -= 1;
    }

    for (auto student : reserve)
    {
        uniformCount[student] += 1;
    }

    int answer = 0;
    for (int i = 1; i <= n; i++)
    {
        if (uniformCount[i] > 0)
        {
            answer++;
            continue;
        }
        
        if (uniformCount[i - 1] > 1)
        {
            answer++;
        }
        else if (i != n && uniformCount[i + 1] > 1)
        {
            uniformCount[i + 1] -= 1;
            answer++;
        }
    }
    return answer;

}