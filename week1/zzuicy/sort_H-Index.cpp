#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int n = citations.size();
    
    sort(citations.begin(), citations.end(), greater<int>());
    if (citations[0] == 0)
        return 0;

    for (int i = 0; i < n; i++)
    {
        if (citations[i] < i + 1)
            return i;
    }
}