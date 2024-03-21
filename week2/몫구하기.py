def solution(num1, num2):
    answer = num1 // num2 
    # answer = divmod(num1, num2)[0]
    return answer

# // 를 사용하면 몫만 나온다.
# divmod 를 사용하면 0은 몫 1은 나머지

print(solution(10,3))