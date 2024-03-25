#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices)
{
    stack<int> stocks;

    int count = prices.size();
    vector<int> answer(count);

    for (int i = 0; i < count; i++)
    {
        int currentPrice = prices[i];
        while (!stocks.empty() && prices[stocks.top()] > currentPrice)
        {
            answer[stocks.top()] = i - stocks.top();
            stocks.pop();
        }
        stocks.push(i);
    }

    while (!stocks.empty())
    {
        answer[stocks.top()] = (count - 1) - stocks.top();
        stocks.pop();
    }

    return answer;
}