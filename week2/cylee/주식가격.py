def solution(prices): #실패
    answer = [0 for i in range(len(prices))]
    temp = []
    stack = [prices[0]]
    time = 1
    for i in range(1, len(prices)):
        time += 1
        if(prices[i] > stack[-1]):
            stack.append(prices[i])
        else:
            t = time-len(stack)
            temp.append(i)
            answer[i-1] = t
            # stack.pop(-1)
            stack.append(prices[i])
        # print(stack, answer, temp)
    for idx, i in enumerate(stack):
        if(idx+1 not in temp):
            answer[idx] = len(prices)-idx-1
    return answer

print(solution([1, 2, 3, 2, 3]	))