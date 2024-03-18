#include <string>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

string solution(vector<int> numbers)
{
    string answer = "";
    vector<string> strnums;

    for (auto i : numbers)
    {
        strnums.push_back(to_string(i));
    }

    sort(strnums.begin(), strnums.end(),
         [](const auto &lhs, const auto &rhs)
         {
             return lhs + rhs > rhs + lhs;
         });
    
    if (strnums[0] == "0")
        return "0";
    
    answer = accumulate(strnums.begin(), strnums.end(), string{});
    return answer;
}