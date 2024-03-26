#include <string>
#include <vector>

using namespace std;

int count = -1;
int answer = 0;
string target = "";
string aeiou = "AEIOU";

void dfs(string word)
{
    count++;

    if (word == target)
    {
        answer = count;
        return;
    }

    if (word.length() >= 5)
        return;

    for (int i = 0; i < 5; i++)
    {
        dfs(word + aeiou[i]);
    }
}

int solution(string word)
{
    target = word;
    dfs("");
    return answer;
}