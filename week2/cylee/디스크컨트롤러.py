def solution(jobs):#실패
    answer = 0
    time = 0
    temp = sorted(jobs, key=lambda x:x[1])
    for i in temp:
        if(time >= i[0]):
            time += i[1]
            answer += time-i[0]
    return answer//len(jobs)

print(solution([[0, 3], [1, 9], [2, 6]]	))