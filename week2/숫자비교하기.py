def solution(num1, num2):
    answer = 0
    if num1 == num2:
        answer = 1
    else:
        answer = -1 
    return answer

# num1, num2 가 다르면 -1 같으면 1

# 파이썬의 삼항 조건표현식으로 한 줄로도 가능함

def solution2(num1, num2):
    return 1 if num1 == num2 else -1

print(solution(1,2))
print(solution(1,1))
print(solution(1,3))
print(solution2(1,2))
print(solution2(1,1))
print(solution2(1,3))
