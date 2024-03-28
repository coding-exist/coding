def solution(arr):
    answer = []
    flag = -1 # 플래그로 연속된 숫자인지 비교
    for i in arr:
        if flag != i:
            answer.append(i)
            flag = i

    return answer

print(solution([1,1,3,3,0,1,1]	))