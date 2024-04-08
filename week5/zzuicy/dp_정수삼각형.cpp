#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle)
{
    vector<vector<int>> answer(triangle);

    // 삼각형 밑변부터 출발
    int height = triangle.size();
    for (int y = height - 1; y >= 1; y--)
    {
        int width = triangle[y].size();
        for (int x = 0; x < width; x++)
        {
            auto &upper = triangle[y - 1];
            int left = x <= 0 ? x : x - 1;
            int right = x >= upper.size() ? upper.size() - 1 : x;

            // 왼쪽 값 갱신, x 가 왼쪽 끝에 있는 경우 제외
            if (x > 0) 
            {
                answer[y - 1][left] = max(answer[y - 1][left], answer[y][x] + upper[left]);
            }

            // 오른쪽 값 갱신, x 가 오른쪽 끝에 있는 경우 제외
            if (x < width - 1) 
            {
                answer[y - 1][right] = max(answer[y - 1][right], answer[y][x] + upper[right]);
            }
        }
    }

    return answer[0][0];
}