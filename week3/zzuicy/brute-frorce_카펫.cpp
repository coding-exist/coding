#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow)
{
    // brown = width * 2 + ((height - 2) * 2)
    // brown = (width + height - 2) * 2

    int sum_wh = (brown / 2) + 2;
    int area = brown + yellow;

    int height = sum_wh / 2;
    int width = sum_wh - height;

    while (width * height != area)
    {
        width++;
        height--;
    }

    return {width, height};
}