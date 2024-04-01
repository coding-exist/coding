#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes)
{
    int maxWidth = 0;
    int maxHeight = 0;
    for (auto size : sizes)
    {
        int width = size[0];
        int height = size[1];

        maxWidth = max(maxWidth, max(width, height));
        maxHeight = max(maxHeight, min(width, height));
    }

    return maxWidth * maxHeight;
}