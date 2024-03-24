#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

struct Job
{
    int requestTime;
    int workingTime;
};

struct CompareJob
{
    bool operator()(const Job &a, const Job &b)
    {
        return a.workingTime > b.workingTime; // 오름차순 정렬 기준
    }
};

int solution(vector<vector<int>> jobs)
{
    // 요청 시간 순으로 정렬
    sort(jobs.begin(), jobs.end(), [](const auto &vec1, const auto &vec2)
         { return vec1[0] < vec2[0]; });

    queue<Job> jobQ;
    priority_queue<Job, vector<Job>, CompareJob> waitingQ;
    for (int i = 0; i < jobs.size(); i++)
    {
        int requestTime = jobs[i][0];
        int workingTime = jobs[i][1];
        jobQ.push({requestTime, workingTime});
    }

    int currentTime = 0;
    int allWorkingTime = 0;
    while (!jobQ.empty() || !waitingQ.empty())
    {
        if (waitingQ.empty())
        {
            if (currentTime == jobQ.front().requestTime)
            {
                currentTime += jobQ.front().workingTime;
                allWorkingTime += currentTime - jobQ.front().requestTime;
                jobQ.pop();
            }
            else
            {
                currentTime++;
            }
        }
        else
        {
            currentTime += waitingQ.top().workingTime;
            allWorkingTime += currentTime - waitingQ.top().requestTime;
            waitingQ.pop();
        }

        while (!jobQ.empty() && jobQ.front().requestTime <= currentTime)
        {
            waitingQ.push(jobQ.front());
            jobQ.pop();
        }
    }

    return allWorkingTime / jobs.size();
}