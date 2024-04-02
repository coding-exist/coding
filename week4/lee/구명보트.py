def solution(people, limit):
    answer = 0
    people.sort() # 정렬하고
    pre,last = 0, len(people)-1
    while pre <= last: # 투포인터 사용해서 
        if(pre == last): # 마지막경우
            answer += 1
            break
        first, second = people[pre], people[last]
        if(first + second <= limit): # 둘이 합해서 되면 같이 넣기
            answer += 1
            pre += 1
            last -= 1
        else: # 아니면 큰 수만 넣기
            answer += 1
            last -= 1
    return answer

print(solution([70, 50, 80, 50]	,100))