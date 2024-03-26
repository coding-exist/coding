#include <string>
#include <vector>
#include <queue>
#include <cstdlib>
#include <algorithm>

using namespace std;

int GetConnectedTop(int start, vector<bool> &visited, const vector<vector<int>> &wires)
{
    int count = 1;
    visited[start] = true;
    queue<int> connectedQ;

    for (int i = 0; i < wires.size(); i++)
    {
        if (wires[i][0] == start)
        {
            connectedQ.push(wires[i][1]);
        }
        else if (wires[i][1] == start)
        {
            connectedQ.push(wires[i][0]);
        }
    }

    while (!connectedQ.empty())
    {
        if (!visited[connectedQ.front()])
            count += GetConnectedTop(connectedQ.front(), visited, wires);

        connectedQ.pop();
    }

    return count;
};

int solution(int n, vector<vector<int>> wires)
{
    int minDiff = n;
    vector<vector<int>> tempWires(wires);
    for (int i = 0; i < wires.size(); i++)
    {
        // 현재 연결을 끊음
        tempWires.erase(tempWires.begin() + i);

        // 각 전력망의 송전탑 개수 체크
        vector<bool> visitedA(n, false);
        int a = GetConnectedTop(wires[i][0], visitedA, tempWires);

        vector<bool> visitedB(n, false);
        int b = GetConnectedTop(wires[i][1], visitedB, tempWires);

        int diff = abs(a - b);
        minDiff = min(minDiff, diff);

        // 연결 원복
        tempWires.insert(tempWires.begin() + i, wires[i]);
    }

    return minDiff;
}

// 의문.. 왜 fill을 써서 visited 배열 재활용을 하면 틀릴까?
int solution_wrong(int n, vector<vector<int>> wires)
{
    int minDiff = n;
    vector<bool> visited(n, false);
    vector<vector<int>> tempWires(wires);
    for (int i = 0; i < wires.size(); i++)
    {
        // 현재 연결을 끊음
        tempWires.erase(tempWires.begin() + i);

        // 각 전력망의 송전탑 개수 체크
        int a = GetConnectedTop(wires[i][0], visited, tempWires);
        fill(visited.begin(), visited.end(), false);

        int b = GetConnectedTop(wires[i][1], visited, tempWires);
        fill(visited.begin(), visited.end(), false);

        int diff = abs(a - b);
        minDiff = min(minDiff, diff);

        // 연결 원복
        tempWires.insert(tempWires.begin() + i, wires[i]);
    }

    return minDiff;
}
