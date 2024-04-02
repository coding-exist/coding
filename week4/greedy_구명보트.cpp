#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit)
{
    int answer = 0;
    int size = people.size();
    
    sort(people.begin(), people.end());
    int lightest = 0;
    int fattest = size - 1;

    while(lightest <= fattest)
    {
        // 일단 보트에 제일 무거운 사람 태움
        int weight = people[fattest];
        fattest--;

        // 제일 가벼운 사람도 태울 수 있으면 태움
        if (weight + people[lightest] <= limit)
        {
            lightest++;
        }

        answer++;
    }
    
    return answer;
}

int solution_timeout(vector<int> people, int limit)
{
    int answer = 0;
    int size = people.size();
    
    vector<bool> rescue(size, false);
    sort(people.begin(), people.end());
    
    for (int i = 0; i < size; i++)
    {
        if (rescue[i])
            continue;

        for (int j = size - 1; j > 0; j--)
        {
            if (rescue[j] || i == j)
                continue;

            if (people[i] + people[j] <= limit)
            {
                rescue[i] = true;
                rescue[j] = true;
                answer++;
                break;
            }
        }
    }

    for (int i = 0; i < size; i++)
    {
        if (!rescue[i])
        {
            answer++;
        }
    }
    return answer;
}