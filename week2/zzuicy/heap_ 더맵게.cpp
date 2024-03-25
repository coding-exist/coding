#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K)
{
    priority_queue<uint32_t, vector<uint32_t>, greater<uint32_t>> minHeap(scoville.begin(), scoville.end());

    int answer = 0;

    while (minHeap.top() < K)
    {
        if (minHeap.size() == 1)
            return -1;

        uint32_t a = minHeap.top();
        minHeap.pop();
        uint32_t b = minHeap.top();
        minHeap.pop();

        answer++;

        uint32_t new_scoville = a + (b * 2);
        minHeap.push(new_scoville);
    }
    
    return answer;
}