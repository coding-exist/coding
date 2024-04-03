def solution(numbers):
    answer = 0
    for i in numbers:
        answer += i
    return answer/len(numbers)

# for 문으로 전체 돌리고 원소 개수만큼 나누기
    
# 오
# return sum(numbers) / len(numbers)