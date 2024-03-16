#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    unordered_map<string, int> total;
    unordered_map<string, vector<pair<int, int>>> ids;
    
    int size = genres.size();
    for (int i = 0; i < size; i++)
    {
        const auto& genre = genres[i];
        total[genre] += plays[i];
        if (ids.find(genre) == ids.end())
            ids[genre] = vector<pair<int, int>>();
        
        ids[genre].emplace_back(i, plays[i]);
    }
    
    vector<pair<string, int>> sortedTotal;
	for (auto& it : total) {
		sortedTotal.emplace_back(it);
	}
    sort(sortedTotal.begin(), sortedTotal.end(), [](const auto& lhs, const auto& rhs) {
            return lhs.second > rhs.second;
            });
    
    vector<int> answers;
    for (const auto& keyValue : sortedTotal)
    {
        auto& musicIds = ids[keyValue.first];
        if (musicIds.size() == 1)
        {
            answers.push_back(musicIds[0].first);
            continue;
        }
        
        sort(musicIds.begin(), musicIds.end(), [](const auto& lhs, const auto& rhs) {
            if (lhs.second == rhs.second) 
            {
               return lhs.first < rhs.first;
            }
            return lhs.second > rhs.second;
            });
        
        for (int i = 0; i < 2; i++)
        {
            answers.push_back(musicIds[i].first);
        }
    }
    return answers;
}