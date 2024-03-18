def find_index(array, target_num):
    res = 0
    for idx,i in enumerate(array):
        if target_num >= i :
            continue
        else:
            return idx
    return res

def solution(citations):
    answer = 0
    temp = sorted(citations)
    max_count = max(temp)
    n = len(citations)
    for i in range(1, max_count):
        idx = find_index(temp, i)
        over_count = n - idx
        if(i<over_count):
            continue
        else:
            answer = i
            break
        
    return answer
print(solution([3, 4]	))