#include <string>
#include <vector>
#include <algorithm>

using namespace std;

const char A = 'A';
const char Z = 'Z';
int solution(string name)
{
    int size = name.size();
    int answer = size - 1;

    // 좌우조작 계산, 0은 시작위치 이므로 계산 X
    for (int i = 1; i < size; i++)
    {
        if (name[i] == A)
        {
            int left = i - 1; // 왼쪽 영역 개수

            while (name[i] == A && i < size)
            {
                i++;
            }

            int right = size - i; // 오른쪽 영역 개수

            answer = min(answer, 2 * left + right); // 왼쪽 -> 오른쪽
            answer = min(answer, 2 * right + left); // 오른쪽 -> 왼쪽
        }
    }

    // 상하조작 계산
    for (int i = 0; i < size; i++)
    {
        if (name[i] == A)
            continue;
        
        answer += min(name[i] - A, Z - name[i] + 1);
    }

    return answer;
}