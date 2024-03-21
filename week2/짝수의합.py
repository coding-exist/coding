def solution(n):
    answer = 0
    # 6 - 6 4 2
    # 5 - 4 2 
    # n 이하의 짝수를 알아야
    # 더할 거다.
    # n이 홀수면 n에 n-1을 해줌. 윗단에서 줄이기.
    if n % 2 != 0:
        n = n - 1
    for n in range(n, 1, -2):
            answer += n
        # range(start, 끝+1, 증가폭)        
    return answer
