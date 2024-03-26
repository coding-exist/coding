from itertools import *

def solution(k, dungeons):
    answer = -1
    for each in list(permutations(dungeons,len(dungeons))): # 라이브러리로 모든 경우의 수 추출
        temp = k
        count = 0
        for req, piro in each:
            if(temp >= req):
                temp -= piro
                count += 1
        answer = max(answer, count)

    return answer
print(solution(80, [[80,20],[50,40],[30,10]]	))