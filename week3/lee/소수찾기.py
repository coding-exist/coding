import itertools
def check(n): # 소수 체크
    if n <= 1:
        return False
    if n <= 2:
        return True
    else:
        for i in range(2,n):
            if n%i == 0:
                return False

    return True

def solution(numbers):

    answer = []
    for j in range(1,len(numbers)+1):
        per = list(map(''.join, itertools.permutations(numbers,j))) # 1~끝까지 뽑기
        per = set(per) # 중복제거
        for i in per:
            p = int(i) # 앞에 0제거
            if check(p):
                answer.append(p)
    answer = set(answer)
    return len(answer)

print(solution("011"	))