#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <math.h>

using namespace std;

// 개선한 문제 풀이
// 만들수 있는 수만 소수 여부 체크함
int solution(string numbers)
{
    sort(numbers.begin(), numbers.end(), greater<char>());
    int max = stoi(numbers);

    auto isPrime = [max](int num) -> bool
    {
        if (num == 2)
            return true;

        if (num == 1 || num % 2 == 0)
            return false;

        for (int i = 2; i <= sqrt(num); i++)
        {
            if (num % i == 0)
                return false;
        }

        return true;
    };

    set<int> answer;
    for (int i = 1; i <= numbers.size(); i++)
    {
        do
        {
            int num = stoi(numbers.substr(0, i));
            if (isPrime(num))
                answer.insert(num);

        } while (prev_permutation(numbers.begin(), numbers.end()));
    }

    return answer.size();
}

// 처음 문제 풀이
// 소수를 모두 구하고 이후에 조합가능 여부를 체크하기 때문에 비효율적
int solution_old(string numbers)
{
    sort(numbers.begin(), numbers.end(), greater<char>());
    int max = stoi(numbers);

    vector<bool> isPrime(max + 1);
    fill(isPrime.begin(), isPrime.end(), true);
    for (int i = 2; i <= sqrt(max); i++)
    {
        if (!isPrime[i])
            continue;

        for (int j = i * i; j <= max; j += i)
        {
            isPrime[j] = false;
        }
    }

    int answer = 0;
    for (int i = 2; i <= max; i++)
    {
        if (!isPrime[i])
            continue;

        string tmp = numbers;
        string numStr = to_string(i);
        bool hasNum = true;
        for (auto &c : numStr)
        {
            auto it = find(tmp.begin(), tmp.end(), c);
            if (it == tmp.end())
            {
                hasNum = false;
                break;
            }
            else
            {
                tmp.erase(it);
            }
        }
        answer = hasNum ? answer + 1 : answer;
    }

    return answer;
}