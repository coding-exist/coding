from queue import PriorityQueue
def solution(scoville, K): # 실패
    answer = 0
    
    que = PriorityQueue()
    for i in scoville:
        que.put(i)
    # 우선순위큐로 
    while que.qsize() > 1:
        first = que.get()
        second = que.get()
        total = first + (second*2)

        # 맨앞에 하나 꺼내본 다음에 판단
        que.put(total)
        temp = que.get()
        answer += 1
        if(temp >= K):
            break
        else:
            que.put(temp)
    return answer

print(solution([3, 2, 5, 9, 1, 12]	,7))