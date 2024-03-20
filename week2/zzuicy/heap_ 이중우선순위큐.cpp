#include <string>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations)
{
    deque<int> nums;
    for (auto &op : operations)
    {
        switch (op[0])
        {
        case 'I':
            nums.push_back(stoi(op.substr(2)));
            break;
        case 'D':
            {
                if (nums.empty())
                    break;
                
                sort(nums.begin(), nums.end());
                if (op.find('-') != string::npos)
                {
                    nums.pop_front();
                }
                else
                {
                    nums.pop_back();
                }
            }
            break;
        }
    }

    vector<int> answer = {0, 0};
    if (!nums.empty())
    {
        sort(nums.begin(), nums.end());
        answer[0] = nums.back();
        answer[1] = nums.front();
    }

    return answer;
}