def solution(answers):
    result = [0,0,0]
    answer = []
    # 미리 정답 패턴 구해놓고
    a = [1,2,3,4,5]
    b = [2,1,2,3,2,4,2,5]
    c = [3,3,1,1,2,2,4,4,5,5]
    for idx,i in enumerate(answers):
        # 결과값을 카운팅
        if(a[idx%len(a)] == i): result[0] += 1
        if(b[idx%len(b)] == i): result[1] += 1
        if(c[idx%len(c)] == i): result[2] += 1
    
    max_num = max(result)
    for i in range(len(result)): # 중복 1위가 있을수도 있어서 모든 경우 탐색
        if result[i] == max_num:
            answer.append(i+1)
            
    return answer

print(solution([1,2,3,4,5]	))