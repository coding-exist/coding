def solution(priorities, location):
    answer = 0
    queue = []
    for idx, prior in enumerate(priorities):# 큐에 인덱스 포함해서 넣기
        queue.append([idx, prior])
    max_num = max(i[1] for i in queue)
    count = 0 # 몇개 프로세스 완료 되었는지에 대한 순서

    while len(queue) != 0:
        if(max_num > queue[0][1]):# 최대값보다 작은 경우 다시 큐 뒤로 넣기
            queue.append(queue.pop(0))
        else:
            i, each = queue.pop(0)
            if len(queue) != 0:
                max_num =  max(i[1] for i in queue)
            count += 1
            if(location == i):
                answer = count
                break  
    return answer
print(solution([9, 9, 6], 2))