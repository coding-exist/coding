#include <string>
#include <vector>

using namespace std;

int clear(int depth, int energy, const vector<vector<int>> &dungeons)
{
    int maxCount = depth;
    for (int i = 0; i < dungeons.size(); i++)
    {
        if (energy < dungeons[i][0])
            continue;

        vector<vector<int>> remainDungeons(dungeons);
        remainDungeons.erase(remainDungeons.begin() + i);

        int clearCount = clear(depth + 1, energy - dungeons[i][1], remainDungeons);
        maxCount = max(maxCount, clearCount);
    }
    return maxCount;
}

int solution(int k, vector<vector<int>> dungeons)
{
    return clear(0, k, dungeons);
}