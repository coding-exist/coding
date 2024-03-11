def solution(numbers):
    answer = ''
    temp = []
    for i in numbers:
        temp.append([str(i)*3, i])
    temp.sort(key=lambda x: x[0], reverse=True)
    for i,j in temp:
        answer += str(j)
    return str(int(answer))
print(solution([0, 0]	))